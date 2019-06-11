package gruppen;

import javax.swing.JInternalFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JTextArea;

import Main.Listener;
import Main.Var;


public class GUI_Details_G extends JInternalFrame {

	protected static JTextField txtName;
	protected static JTextArea txtAA;
	Choice choice_tag;
	int id;
	JInternalFrame pan;

	String name, anmerkung;
	int tag;

	private AL_GUI_New al = new AL_GUI_New(this);
	private MySQLZugriff mz;
	Border mb_bottom = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);

	public GUI_Details_G(int i, JInternalFrame pan) {

		this.pan = pan;
		this.id = i;
		mz = new MySQLZugriff(i);
		try {
			mz.rs.next();
			name = mz.rs.getString("name");
			anmerkung = mz.rs.getString("anmerkung");

			tag = numofGesch(mz.rs.getString("tag"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
		setBorder(null);
	}

	private void initialize() {

//		System.out.println(name+vorname+strasse+ ort+  email+ mutter+ vater+  anmerkung+ bild);
		setBorder(mb_bottom);
		setTitle(name);
		setToolTipText("Details Gruppe");
		setBounds(0, 0, 968, 628
			);
		setResizable(false);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
//		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new Listener(this, pan));

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

		JLabel lblTag = new JLabel("Tag");
		lblTag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTag.setBounds(30, 105, 100, 20);
		getContentPane().add(lblTag);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(30, 60, 200, 25);
		txtName.setText(name);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		choice_tag = new Choice();
		choice_tag.setBounds(30, 135, 200, 2);
		choice_tag.add("Montag");
		choice_tag.add("Dienstag");
		choice_tag.add("Mittwoch");
		choice_tag.add("Donnerstag");
		choice_tag.add("Freitag");
		choice_tag.add("Samstag");
		choice_tag.add("Sonntag");
		choice_tag.select(tag);
		getContentPane().add(choice_tag);

		JLabel lblAnmerkungen = new JLabel("Anmerkungen");
		lblAnmerkungen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnmerkungen.setBounds(30, 175, 100, 20);
		getContentPane().add(lblAnmerkungen);

		txtAA = new JTextArea();
		txtAA.setText(anmerkung);
		txtAA.setBounds(30, 205, 471, 100);
		getContentPane().add(txtAA);
//          getContentPane().revalidate(); //ADD THIS AS WELL
//          getContentPane().repaint();  //ADD THIS AS WELL

		
		setVisible(true);

	}

	private int numofGesch(String tag) {

		int i = 0;

		if (tag.equals("Montag")) {
			i = 0;
		} else if (tag.equals("Dienstag")) {
			i = 1;
		} else if (tag.equals("Mittwoch")) {
			i = 2;
		} else if (tag.equals("Donnerstag")) {
			i = 3;
		} else if (tag.equals("Freitag")) {
			i = 4;
		} else if (tag.equals("Samstag")) {
			i = 5;
		} else if (tag.equals("Sonntag")) {
			i = 6;
		}

		return i;
	}

	class AL_GUI_New implements ActionListener {

		private JInternalFrame frame;
		JFileChooser fc = new JFileChooser();
		private JLabel lbl;
		JLabel image;
		String sname;
		File file;

		public AL_GUI_New(JInternalFrame frame) {

			this.frame = frame;
		}

		public AL_GUI_New(JInternalFrame frame, JLabel lbl) {

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

					mz.stmt.execute("UPDATE gruppen SET name = '" + txtName.getText() + "'," + "tag='"
							+ choice_tag.getSelectedItem() + "',anmerkung='" + txtAA.getText() + "'" + "WHERE ID="
							+ id);
					System.out.println("Fertig");
					mz.con.close();
				}

				catch (SQLException e2) {
					// TODO Auto-generated catch block
					System.out.println("fuck");
					e2.printStackTrace();
				}

			}

		}

	}
}
