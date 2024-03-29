package mitarbeiter;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.Listener;
import kunden.GUI_Details_K;

public class GUI_Mitarbeiter extends JInternalFrame {

	JTable table;
	MySQLZugriff mz;
	JButton edit;
	int rh=20;
	JPanel panel; 
	JDesktopPane pan;
	
	public GUI_Mitarbeiter(JDesktopPane pan)  {
		
		
		this.pan = pan;
		mz= new MySQLZugriff();
		initialize();
		

	}
	
	

	private void startDetails(int row, int column) {
		
		String name = (String) table.getValueAt(row, 1);
		String vname = (String) table.getValueAt(row, 2);
		int x = (int) table.getValueAt(row, 0);
		
		int i =JOptionPane.showConfirmDialog(pan, "Wollen Sie "+vname+" "+name+" bearbeiten ?","Bearbeiten",JOptionPane.YES_NO_OPTION);
		if(i == 0) { 
		pan.add(new GUI_Details_M(x,this));
		System.out.println(x);
		try {
			setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	private void initialize() {
		
		panel = new JPanel();
		panel.setBounds(10, 10, 948, 588);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable(model());
		table.setBounds(0, 0, 948, 588);
		
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(0, 0, 948, 588);
		panel.add( scrollPane );
		
		setTitle("Mitarbeiter");
		setBounds(0, 0, 968, 628);
		setBorder(null);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setPreferredSize(new Dimension(200,200));
		addInternalFrameListener(new Listener(this));
	
		
		
		
		
	}
	//erstellt eine DefaultTabelle und f�llt diese mit Infos aus der Datenbank
	private DefaultTableModel model() {
		
		final DefaultTableModel model = new DefaultTableModel(){
	    	public boolean isCellEditable(int row, int column)
	    	{
	    		
	    		startDetails(row, column);
	    		return false;
	    	}
		};
		
		model.setColumnIdentifiers(new Object[] {"ID","Name","Vorname","Star�e","Hausnr.","Plz","Ort"});
		 
		 Random random = new Random();
	        try {
	        	//Erzeugt Objekt und f�gt diese der Tabelle zu solagne noch datens�tze ind der DB vorhanden sind 
				while(mz.rs.next()){
				    Object[] row = fillTable();
				    
				
				    
				    model.addRow( row );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return model;
	}
	//Erstellt ein Objekt mit Informationen aus der Datenbank.
	private Object[] fillTable() throws SQLException {
		
	Object[] row = new Object[] {mz.rs.getInt("ID"),mz.rs.getString("name"),mz.rs.getString("vorname"),mz.rs.getString("strasse"),
			mz.rs.getInt("hausnr"),mz.rs.getInt("plz"),mz.rs.getString("Ort")};
	
	System.out.println("fetig");
	return row;
		
	}
	
}

	