package mitarbeiter;

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

import Main.AL;
import Main.Listener;
import Main.SetMaxText;
import Main.Var;




public class GUI_New_M extends JInternalFrame {
	
	protected static JTextField txtName;
	protected static JTextField txtVorname;
	protected static JTextField txtStr;
	protected static JTextField txtHnr;
	protected static JTextField txtPlz;
	protected static JTextField txtTelNum;
	protected static JTextField txtBez;
	protected static JTextField txtOrt;
	protected static JTextField txtEmail;
	protected static JTextField txtGeb1;
	protected static JTextArea txtAA;
	Choice choice_gesch;
	
	private AL_GUI_New al = new AL_GUI_New(this);
	private MySQLZugriff mz;
	
	
	public GUI_New_M() {
		setBorder(null);
		initialize();
		

	}
	private void initialize() {
		
		setTitle("Neuer Mitarbeiter");
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
		
		JButton btnBildAuswahl = new JButton("Bild auswahl");
		btnBildAuswahl.setBounds(774, 297, 120, 23);
		btnBildAuswahl.addActionListener(al);
		getContentPane().add(btnBildAuswahl);		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(30, 30, 50, 20);
		getContentPane().add(lblName);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVorname.setBounds(300, 30, 100, 20);
		getContentPane().add(lblVorname);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe");
		lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStrae.setBounds(30, 100, 100, 20);
		getContentPane().add(lblStrae);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHausnummer.setBounds(300, 100, 100, 20);
		getContentPane().add(lblHausnummer);
		
		JLabel lblPlz = new JLabel("Plz");
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlz.setBounds(30, 170, 100, 20);
		getContentPane().add(lblPlz);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrt.setBounds(300, 170, 100, 20);
		getContentPane().add(lblOrt);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnr.");
		lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefonnummer.setBounds(30, 240, 100, 20);
		getContentPane().add(lblTelefonnummer);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(300, 240, 100, 20);
		getContentPane().add(lblEmail);
		
		JLabel lblBez = new JLabel("Bezeichnung");
		lblBez.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBez.setBounds(30, 310, 100, 20);
		getContentPane().add(lblBez);
		
		JLabel lblGeb = new JLabel("Geburtstag");
		lblGeb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGeb.setBounds(300, 310, 100, 20);
		getContentPane().add(lblGeb);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGeschlecht.setBounds(30, 380, 100, 20);
		getContentPane().add(lblGeschlecht);

		JLabel lblAnmerkungen = new JLabel("Anmerkungen");
		lblAnmerkungen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnmerkungen.setBounds(30, 450, 100, 20);
		getContentPane().add(lblAnmerkungen);
		
		
		txtName = new JTextField();
		txtName.setText("-");
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(30, 60, 200, 25);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtVorname = new JTextField();
		txtVorname.setText("-");
		txtVorname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVorname.setColumns(10);
		txtVorname.setBounds(300, 60, 200, 25);
		getContentPane().add(txtVorname);
		
		txtStr = new JTextField();
		txtStr.setText("-");
		txtStr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStr.setColumns(10);
		txtStr.setBounds(30, 130, 200, 25);
		getContentPane().add(txtStr);
		
		txtHnr = new JTextField();
		txtHnr.setText("-");
		txtHnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHnr.setColumns(10);
		txtHnr.setBounds(300, 130, 200, 25);
		getContentPane().add(txtHnr);
		
		txtPlz = new JTextField();
		txtPlz.setText("-");
		txtPlz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPlz.setColumns(10);
		txtPlz.setBounds(30, 200, 200, 25);
		getContentPane().add(txtPlz);
		
		txtTelNum = new JTextField();
		txtTelNum.setText("-");
		txtTelNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelNum.setColumns(10);
		txtTelNum.setBounds(30, 270, 200, 25);
		getContentPane().add(txtTelNum);
		
		txtBez = new JTextField();
		txtBez.setText("-");
		txtBez.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBez.setColumns(10);
		txtBez.setBounds(30, 340, 200, 25);
		getContentPane().add(txtBez);
		
		txtOrt = new JTextField();
		txtOrt.setText("-");
		txtOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOrt.setColumns(10);
		txtOrt.setBounds(300, 201, 200, 25);
		getContentPane().add(txtOrt);
		
		txtEmail = new JTextField();
		txtEmail.setText("-");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(300, 271, 200, 25);
		getContentPane().add(txtEmail);
		
		choice_gesch = new Choice();
		choice_gesch.setBounds(30, 410, 200, 20);
		choice_gesch.add("weiblich");
		choice_gesch.add("männlich");
		choice_gesch.add("diverse");
		getContentPane().add(choice_gesch);
		
		txtAA = new JTextArea();
		txtAA.setText("-");
		txtAA.setBounds(30, 480, 471, 100);
		getContentPane().add(txtAA);
		
	
		
		txtGeb1 = new JTextField();
		txtGeb1.setText("");
		txtGeb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGeb1.setColumns(10);
		txtGeb1.setDocument(new SetMaxText(10));
		txtGeb1.addKeyListener(new AL(txtGeb1));
		txtGeb1.setBounds(300, 410, 200, 25);
		getContentPane().add(txtGeb1);
		
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
			Var.setBtn_new(false);
		}
		if (s.equals("Speichern")) {
			
			mz = new MySQLZugriff();
			
			try {
				mz.stmt.execute("INSERT INTO mitarbeiter (name,vorname,strasse,hausnr,plz, ort, telnr, email, bezeichnung, geschlecht, geburtstag, anmerkung, bild)" + 
						" VALUES ('"+txtName.getText()+"', '"+txtVorname.getText()+"', '"+txtStr.getText()+"',"+Integer.parseInt(txtHnr.getText())+","+Integer.parseInt(txtPlz.getText())+","
						+" '"+txtOrt.getText()+"',"+Integer.parseInt(txtTelNum.getText())+",'"+txtEmail.getText()+"', '"+txtBez.getText()
						+"','"+choice_gesch.getSelectedItem()+"','"+txtGeb1.getText()+"','"+txtAA.getText()+"','MitarbeiterImg/"+file.getName()+"');");
				
				System.out.println("Fertig");
				mz.con.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("fuck");e2.printStackTrace();
			}
			if (file != null) {
				
			 try {
	            	sname = copyFile(file, "MitarbeiterImg/");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			GUI_New_M.txtName.setText("");                                   
			GUI_New_M.txtVorname.setText("");                                   
			GUI_New_M.txtStr.setText("");                                   
			GUI_New_M.txtHnr.setText("");                                   
			GUI_New_M.txtPlz.setText("");                                   
			GUI_New_M.txtTelNum.setText("");                                   
			GUI_New_M.txtOrt.setText("");                                   
			GUI_New_M.txtBez.setText("");                                                                    
			GUI_New_M.txtEmail.setText("");
			GUI_New_M.txtGeb1.setText("");
			GUI_New_M.txtAA.setText("");
			frame.remove(image);
			 frame.revalidate(); //ADD THIS AS WELL
	            frame.repaint(); 
		}
		
		
	}
	   private String copyFile(File source, String pathTarget) throws IOException{
		   //Kopiert das im FileCooser ausgewählte Bild in den Ordner KundenImg und gibt die Location des kopierten
		   //Bildes zurück.
		   
		   String fileLoc =pathTarget+source.getName();
		   Path FROM = Paths.get(source.getAbsolutePath());
		    Path TO = Paths.get(fileLoc);		    
		    Files.copy(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
		    return fileLoc;
	    }

}
}
