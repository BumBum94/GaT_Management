package mitarbeiter;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JTextArea;

import Main.AL;
import Main.Listener;
import Main.SetMaxText;
import Main.Var;




public class GUI_Details_M extends JInternalFrame {
	
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
	JLabel image;
	int id;
	JInternalFrame pan;
	
	String name,vorname,strasse, ort,  email, bez,  anmerkung, bild, geb;
	int hausnr,plz,telnr,geschlecht;
	
	
	private AL_GUI_New al = new AL_GUI_New(this);
	private MySQLZugriff mz;
	
	public GUI_Details_M(int i,JInternalFrame pan) {
		
		this.pan = pan;
		this.id = i;
		mz= new MySQLZugriff(i);
		try {
			mz.rs.next();
			name = mz.rs.getString("name");
			vorname = mz.rs.getString("vorname");
			strasse = mz.rs.getString("strasse");
			ort = mz.rs.getString("ort");
			email = mz.rs.getString("email");
			bez = mz.rs.getString("bezeichnung");
			anmerkung = mz.rs.getString("anmerkung");
			bild = mz.rs.getString("bild");
			geb = mz.rs.getString("geburtstag");
			hausnr = mz.rs.getInt("hausnr");
			plz = mz.rs.getInt("plz");
			telnr = mz.rs.getInt("telnr");
			geschlecht = numofGesch(mz.rs.getString("geschlecht"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
		setBorder(null);
		System.out.println("test");
	}
	
	private void initialize() {
		
//		System.out.println(name+vorname+strasse+ ort+  email+ mutter+ vater+  anmerkung+ bild);
		
		setTitle(name+" "+vorname);
		setToolTipText("Info");
		setBounds(0, 0, 968, 628);
		setResizable(false);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
//		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new Listener(this,pan));
		
		
		JButton btnSchlieen = new JButton("Beenden");
		btnSchlieen.setBounds(850, 567, 89, 23);
		btnSchlieen.addActionListener(al);
		getContentPane().add(btnSchlieen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(740, 567, 100, 23);
		btnSpeichern.addActionListener(al);
		getContentPane().add(btnSpeichern);
		
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
		
		JLabel lblVater = new JLabel("Geburtstag");
		lblVater.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVater.setBounds(300, 310, 100, 20);
		getContentPane().add(lblVater);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGeschlecht.setBounds(30, 380, 100, 20);
		getContentPane().add(lblGeschlecht);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(30, 60, 200, 25);
		txtName.setText(name);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtVorname = new JTextField();
		txtVorname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtVorname.setColumns(10);
		txtVorname.setText(vorname);
		txtVorname.setBounds(300, 60, 200, 25);
		getContentPane().add(txtVorname);
		
		txtStr = new JTextField();
		txtStr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStr.setColumns(10);
		txtStr.setText(strasse);
		txtStr.setBounds(30, 130, 200, 25);
		getContentPane().add(txtStr);
		
		txtHnr = new JTextField();
		txtHnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHnr.setColumns(10);
		txtHnr.setText(String.valueOf(hausnr));
		txtHnr.setBounds(300, 130, 200, 25);
		getContentPane().add(txtHnr);
		
		txtPlz = new JTextField();
		txtPlz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPlz.setColumns(10);
		txtPlz.setText(String.valueOf(plz));
		txtPlz.setBounds(30, 200, 200, 25);
		getContentPane().add(txtPlz);
		
		txtTelNum = new JTextField();
		txtTelNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelNum.setColumns(10);
		txtTelNum.setText("0"+String.valueOf(telnr));
		txtTelNum.setBounds(30, 270, 200, 25);
		getContentPane().add(txtTelNum);
		
		txtBez = new JTextField();
		txtBez.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBez.setColumns(10);
		txtBez.setText(bez);
		txtBez.setBounds(30, 340, 200, 25);
		getContentPane().add(txtBez);
		
		txtOrt = new JTextField();
		txtOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOrt.setColumns(10);
		txtOrt.setText(ort);
		txtOrt.setBounds(300, 201, 200, 25);
		getContentPane().add(txtOrt);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setText(email);
		txtEmail.setBounds(300, 271, 200, 25);
		getContentPane().add(txtEmail);
		
		choice_gesch = new Choice();
		choice_gesch.setBounds(30, 410, 200, 2);
		choice_gesch.add("weiblich");
		choice_gesch.add("männlich");
		choice_gesch.add("diverse");
		choice_gesch.select(geschlecht);
		getContentPane().add(choice_gesch);
		
		txtGeb1 = new JTextField();
		txtGeb1.setDocument(new SetMaxText(10));
		txtGeb1.addKeyListener(new AL(txtGeb1));
		txtGeb1.setText(geb);
		txtGeb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGeb1.setColumns(10);
		txtGeb1.setBounds(300, 341, 200, 25);
		getContentPane().add(txtGeb1);
		
		JLabel lblAnmerkungen = new JLabel("Anmerkungen");
		lblAnmerkungen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnmerkungen.setBounds(30, 450, 100, 20);
		getContentPane().add(lblAnmerkungen);
		
		txtAA = new JTextArea();
		txtAA.setText(anmerkung);
		txtAA.setBounds(30, 480, 471, 100);
		getContentPane().add(txtAA);
		
		  image = new JLabel("", new ImageIcon(bild), JLabel.CENTER);
          image.setBounds(727, 11, 215, 275);
          getContentPane().add(image, BorderLayout.CENTER);
//          getContentPane().revalidate(); //ADD THIS AS WELL
//          getContentPane().repaint();  //ADD THIS AS WELL
		
		JButton btnBildAuswahl = new JButton("Bild auswahl");
		btnBildAuswahl.setBounds(774, 297, 120, 23);
		btnBildAuswahl.addActionListener(al);
		getContentPane().add(btnBildAuswahl);
		setVisible(true);
		
		
		
	}
	  private int numofGesch(String geschlecht) {
			
			int i ; 
			
			if (geschlecht.equals("weiblich")) {
				i = 0;
			}
			else if (geschlecht.equals("männlich")) {
				i = 1;
			}
			else {
				i= 2;
			}
			return i;
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
			Var.setBtn_edit(false);
			try {
				pan.setIcon(false);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (s.equals("Speichern")) {
			
			mz = new MySQLZugriff();
			
			try {
				if (file == null) {
				mz.stmt.execute("UPDATE mitarbeiter SET name = '"+txtName.getText()+"'"
						+ ",vorname = '"+txtVorname.getText()+ "',strasse='"+txtStr.getText()+"',hausnr='"+Integer.parseInt(txtHnr.getText())+"',"
								+ "plz='"+Integer.parseInt(txtPlz.getText())+"', ort='"+txtOrt.getText()+"',"
										+ "telnr='"+Integer.parseInt(txtTelNum.getText())+"',email='"+txtEmail.getText()+"',"
												+ "bezeichnung='"+txtBez.getText()+"',"
														+ "geschlecht='"+choice_gesch.getSelectedItem()+"',geburtstag='"+txtGeb1.getText()+
														"',anmerkung='"+txtAA.getText()+"'"
																+ "WHERE ID="+id);
				
				System.out.println("Fertig");
				mz.con.close();
			} 
				else {
					mz.stmt.execute("UPDATE mitarbeiter SET name = '"+txtName.getText()+"'"
							+ ",vorname = '"+txtVorname.getText()+ "',strasse='"+txtStr.getText()+"',hausnr='"+Integer.parseInt(txtHnr.getText())+"',"
									+ "plz='"+Integer.parseInt(txtPlz.getText())+"', ort='"+txtOrt.getText()+"',"
											+ "telnr='"+Integer.parseInt(txtTelNum.getText())+"',email='"+txtEmail.getText()+"',"
													+ "mutter='"+txtBez.getText()+"',"
															+ "geschlecht='"+choice_gesch.getSelectedItem()+"',anmerkung='"+txtAA.getText()+"',"
																	+ "bild='KundenImg/"+file.getName()+"' WHERE ID="+id);
					System.out.println("Fertig");
					mz.con.close();
				}
			}
				catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("fuck");e2.printStackTrace();
			}
			
			
			if (file != null) {
				
			 try {
	            	sname = copyFile(file, "KundenImg/");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		if (s.equals("Bild auswahl")) {
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
	
		
		
	}
	   private String copyFile(File source, String pathTarget) throws IOException{
		   
		   String fileLoc =pathTarget+source.getName();
		   Path FROM = Paths.get(source.getAbsolutePath());
		    Path TO = Paths.get(fileLoc);		    
		    Files.copy(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
		    return fileLoc;
	    }
	 

}
}
