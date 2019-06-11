package kunden;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.Listener;
import mitarbeiter.GUI_Details_M;

public class GUI_Kunden extends JInternalFrame {

	JTable table;
	MySQLZugriff mz;
	JButton edit;
	int rh=20;
	JPanel panel; 
	JDesktopPane pan;
	int clicked;
	
	public GUI_Kunden(JDesktopPane pan)  {
		
		
		this.pan = pan;
		mz= new MySQLZugriff("kunden");
		initialize();
		

	}
	
private void startDetails(int row, int column) {
		
		int x = (int) table.getValueAt(row, column);
		pan.add(new GUI_Details_K(x));
		System.out.println(x);
		try {
			setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		setTitle("Kunden");
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
	//erstellt eine DefaultTabelle und füllt diese mit Infos aus der Datenbank
	private DefaultTableModel model() {
		
		final DefaultTableModel model = new DefaultTableModel(){
	    	public boolean isCellEditable(int row, int column)
	    	{
	    		clicked++;
	    		if (clicked == 2) {
	    		startDetails(row, column);
	    		clicked =0;
	    		}
	    		return false;
	    	}
		};
		
		model.setColumnIdentifiers(new Object[] {"ID","Name","Vorname","Starße","Hausnr.","Plz","Ort"});
		 
		 Random random = new Random();
	        try {
	        	//Erzeugt Objekt und fügt diese der Tabelle zu solagne noch datensätze ind der DB vorhanden sind 
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
	