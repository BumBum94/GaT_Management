package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class Main_GUI {

	private JFrame frame;
	//Verschieden Border für JLabel.
	Border b = LineBorder.createGrayLineBorder();
	Border mb_top = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
	Border mb_side = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK);
	
	public Main_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1084, 50);
		panel.setBorder(mb_top);
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 50, 115, 661);
		panel_1.setBorder(mb_side);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JDesktopPane panel_2 = new JDesktopPane();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(116, 50, 968, 661);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNew = new JLabel("");
		lblNew.setBounds(5, 2, 45, 45);
		lblNew.setToolTipText("Neu");
		lblNew.setIcon(new ImageIcon("img/new.png"));
		lblNew.addMouseListener(new ML_Main(lblNew,panel_2));
		panel.add(lblNew);
		
		JLabel lblBearbeiten = new JLabel("");
		lblBearbeiten.setToolTipText("Kunde bearbeiten");
		lblBearbeiten.setIcon(new ImageIcon("img/bearbeiten.png"));
		lblBearbeiten.setBounds(60, 2, 45, 45);
		lblBearbeiten.addMouseListener(new ML_Main(lblBearbeiten,panel_2));
		panel.add(lblBearbeiten);
		
		JLabel lblLöschen = new JLabel("");
		lblLöschen.setToolTipText("Kunde löschen");
		lblLöschen.setIcon(new ImageIcon("img/del.png"));
		lblLöschen.setBounds(120, 2, 45, 45);
		lblLöschen.addMouseListener(new ML_Main(lblLöschen));
		panel.add(lblLöschen);
		
		JLabel lblBg = new JLabel("");
		lblBg.setBounds(584, 0, 500, 47);
		lblBg.setIcon(new ImageIcon("img/bg.png"));
		panel.add(lblBg);
		
		
		
		JLabel lblMen = new JLabel("Men\u00FC");
		lblMen.setBounds(10, 11, 51, 22);
		lblMen.setHorizontalAlignment(SwingConstants.LEFT);
		lblMen.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblMen);
		
		JLabel label = new JLabel("--------------");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(0, 22, 115, 22);
		panel_1.add(label);
		
		JLabel lblKunden = new JLabel(" Kunden");
		lblKunden.setToolTipText("Kunden");
		lblKunden.setForeground(Color.BLUE);
		lblKunden.setBounds(10, 44, 90, 20);
		lblKunden.addMouseListener(new ML_Main(lblKunden,panel_2));
		panel_1.add(lblKunden);
		lblKunden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblGrp = new JLabel(" Gruppen");
		lblGrp.setToolTipText("Gruppen");
		lblGrp.setForeground(Color.BLUE);
		lblGrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrp.setBounds(10, 72, 90, 20);
		lblGrp.addMouseListener(new ML_Main(lblGrp));
		panel_1.add(lblGrp);
		
		JLabel lblMitarbeiter = new JLabel(" Mitarbeiter");
		lblMitarbeiter.setToolTipText("Mitarbeiter");
		lblMitarbeiter.setForeground(Color.BLUE);
		lblMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMitarbeiter.setBounds(10, 100, 90, 20);
		lblMitarbeiter.addMouseListener(new ML_Main(lblMitarbeiter,panel_2));
		panel_1.add(lblMitarbeiter);
		
		JLabel lblBuchungen = new JLabel(" Buchungen");
		lblBuchungen.setToolTipText("Buchungen");
		lblBuchungen.setForeground(Color.BLUE);
		lblBuchungen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuchungen.setBounds(10, 128, 90, 20);
		lblBuchungen.addMouseListener(new ML_Main(lblBuchungen));
		panel_1.add(lblBuchungen);
		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setToolTipText("Einstellungen");
		lblEinstellungen.setForeground(Color.BLUE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEinstellungen.setBounds(10, 633, 84, 17);
		lblEinstellungen.addMouseListener(new ML_Main(lblEinstellungen,panel_2));
		panel_1.add(lblEinstellungen);
		
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.pack();
		frame.setVisible(true);
	}
}
