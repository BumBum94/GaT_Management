package gruppen;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import Main.Var;
import Main.AL;
import Main.Listener;
import Main.SetMaxText;

public class GUI_New_G extends JInternalFrame {
	
	private AL_GUI_New al = new AL_GUI_New(this);
	private MySQLZugriff mz;
	private static JTextField textField;
	private static JTextArea txtAA;
	private static Choice choice;
	
	
	public GUI_New_G() {
		setBorder(null);
		initialize();
		

	}
	private void initialize() {
		
		setTitle("Neue Gruppe");
		setBounds(0, 0, 968, 628);
		setResizable(false);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
//		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new Listener(this));
		
		
		JButton btnSchlieen = new JButton("Beenden");
		btnSchlieen.setBounds(850, 567, 89, 23);
		btnSchlieen.addActionListener(al);
		getContentPane().add(btnSchlieen);
		
		JButton btnLschen = new JButton("Leeren");
		btnLschen.setBounds(751, 567, 89, 23);
		btnLschen.addActionListener(al);
		getContentPane().add(btnLschen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(641, 567, 100, 23);
		btnSpeichern.addActionListener(al);
		getContentPane().add(btnSpeichern);
		
		
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(30, 30, 50, 20);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Tag");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(30, 105, 100, 20);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(30, 60, 200, 25);
		getContentPane().add(textField);
		
		choice = new Choice();
		choice.setBounds(30, 135, 200, 20);
		choice.add("Montag");
		choice.add("Dienstag");
		choice.add("Mittwoch");
		choice.add("Donnerstag");
		choice.add("Freitag");
		choice.add("Samstag");
		choice.add("Sonntag");
		getContentPane().add(choice);
		
		JLabel label_2 = new JLabel("Anmerkungen");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(30, 175, 100, 20);
		getContentPane().add(label_2);
		
		txtAA = new JTextArea();
		txtAA.setBounds(30, 205, 471, 100);
		getContentPane().add(txtAA);
		setVisible(true);
		
		
		
	}

class AL_GUI_New implements ActionListener{

	private JInternalFrame frame;
	JFileChooser fc = new JFileChooser();
    private JLabel lbl; 
    JLabel image;
    String sname;
    File file;

	
	public AL_GUI_New(JInternalFrame frame) {

		this.frame = frame;
	}

	public AL_GUI_New(JInternalFrame frame,JLabel lbl) {

		this.frame = frame;
		this.lbl = lbl;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		if (s.equals("Beenden")) {
			frame.dispose();
			Var.setBtn_new_g(false);
		}
		if (s.equals("Speichern")) {
			
			mz = new MySQLZugriff();
			
			try {
				mz.stmt.execute("INSERT INTO gruppen (name,tag, anmerkung)" + 
						" VALUES ('"+textField.getText()+"','"+choice.getSelectedItem()+"','"+txtAA.getText()+"');");
				
				System.out.println("Fertig");
				mz.con.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("fuck");e2.printStackTrace();
			}
			
			
		}
		if (s.equals("Bild auswahl")) {
			//Bild das durch Filechooser ausgewählt wird wird als ImageIcon in ein Label geladen.
			 int result = fc.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            file = fc.getSelectedFile();
		            sname = file.getAbsolutePath();
		           
//		            String sname = file.getAbsolutePath();
		            image = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
		            image.setBounds(727, 11, 215, 275);
		            frame.getContentPane().add(image, BorderLayout.CENTER);
		            frame.revalidate(); //ADD THIS AS WELL
		            frame.repaint();  //ADD THIS AS WELL
		        }
			
		}
		if (s.equals("Leeren")) {
			//Leert alle TXT Felder der GUI
			GUI_New_G.textField.setText("");                                   
			GUI_New_G.txtAA.setText("");
			 frame.revalidate(); //ADD THIS AS WELL
	            frame.repaint(); 
		}
		
		
	}
	

}
}
