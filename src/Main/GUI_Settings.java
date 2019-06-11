package Main;

import java.awt.Dimension;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import javax.swing.JTable;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.awt.event.ActionEvent;

public class GUI_Settings extends JInternalFrame {

	JTable table;
	private JTextField txtServer;
	private JTextField txtUser;
	private JPasswordField txtPw;
	private JPanel panel;
	private JTextField txtPort;
	private JTextField txtDb;
	
	
	
	
	public GUI_Settings()  {

		initialize();
		fillField();

	}
	private void initialize() {
		
		panel = new JPanel();
		panel.setBounds(0, 11, 948, 588);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Beenden");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Var.setBtn_settings(false);
				dispose();
			}
		});
		button.setBounds(849, 548, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Speichern");
		button_1.setBounds(739, 548, 100, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Läd die Informationen für die MySQL Verbinfung in die im Ordner config hinterlegte .properties file
				
				try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Var.propertiesFile))) {
					  Var.properties.load(bis);
					} catch (Exception ex) {
					  //
					}
				Var.properties.setProperty("user", txtUser.getText());
				Var.properties.setProperty("host", txtServer.getText());
				Var.properties.setProperty("password", String.valueOf(txtPw.getPassword()));
				Var.properties.setProperty("port", txtPort.getText());
				Var.properties.setProperty("database", txtDb.getText());
				
				try {
					FileOutputStream out = new FileOutputStream(Var.propertiesFile);
					try {
						Var.properties.store(out, null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel.add(button_1);
		
		JLabel lblServer = new JLabel("Serveradresse");
		lblServer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblServer.setBounds(35, 80, 120, 20);
		panel.add(lblServer);
		
		txtServer = new JTextField();
		txtServer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtServer.setColumns(10);
		txtServer.setBounds(164, 80, 200, 25);
		panel.add(txtServer);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(35, 30, 120, 20);
		panel.add(lblLogin);
		
		JLabel lblNutzer = new JLabel("Nutzer");
		lblNutzer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNutzer.setBounds(34, 125, 120, 20);
		panel.add(lblNutzer);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUser.setColumns(10);
		txtUser.setBounds(164, 125, 200, 25);
		panel.add(txtUser);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(35, 170, 120, 20);
		panel.add(lblPasswort);
		
		txtPw = new JPasswordField();
		txtPw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPw.setColumns(10);
		txtPw.setBounds(164, 167, 200, 25);
		panel.add(txtPw);
		
		JButton btnclear = new JButton("");
		btnclear.setToolTipText("Anzeigen");
		btnclear.setIcon(new ImageIcon("img/eye.png"));
		btnclear.setBounds(374, 170, 20, 20);
		btnclear.addMouseListener(new ML_Settings());
		panel.add(btnclear);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPort.setBounds(35, 215, 120, 20);
		panel.add(lblPort);
		
		JLabel lblDatenbank = new JLabel("Datenbank");
		lblDatenbank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatenbank.setBounds(35, 260, 120, 20);
		panel.add(lblDatenbank);
		
		txtPort = new JTextField();
		txtPort.setText((String) null);
		txtPort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPort.setColumns(10);
		txtPort.setBounds(164, 215, 200, 25);
		panel.add(txtPort);
		
		txtDb = new JTextField();
		txtDb.setText((String) null);
		txtDb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDb.setColumns(10);
		txtDb.setBounds(164, 260, 200, 25);
		panel.add(txtDb);
		
		
		
		setTitle("Einstellungen");
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
	public void fillField() {
		
		
		 //Läd den Inhalt der .properties file in die TXT Felder der GUI 
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Var.propertiesFile))) {
		  Var.properties.load(bis);
		} catch (Exception ex) {
		  //
		}
		 
		txtUser.setText(Var.properties.getProperty("user"));
		txtServer.setText(Var.properties.getProperty("host"));
		txtPw.setText(Var.properties.getProperty("password"));
		txtPort.setText(Var.properties.getProperty("port"));
		txtDb.setText(Var.properties.getProperty("database"));
		
		
	}
	//Innerclass für den kleine Button mit dem Auge hinter dem TXT Feld fürs pw 
	//löscht beim drücken des BUttons das PWTXT Feld und erstzt es durch ein normales gefülltes TXT feld in dem das Passwort steht
	//beim loslassen der Maus wird das TXT Feld wieder durch ein PwTxt Feld ersetzt.
	class ML_Settings implements MouseListener{

		
		String pw;
		JTextField clearPw;
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

			pw = String.valueOf(txtPw.getPassword());
			panel.remove(txtPw);
			
			clearPw = new JTextField(pw);
			clearPw.setFont(new Font("Tahoma", Font.PLAIN, 16));
			clearPw.setColumns(10);
			clearPw.setBounds(164, 167, 200, 25);
			panel.add(clearPw);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			panel.remove(clearPw);
			txtPw = new JPasswordField(pw);
			txtPw.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPw.setColumns(10);
			txtPw.setBounds(164, 167, 200, 25);
			panel.add(txtPw);
			
		}
		
	}
	
}
	


