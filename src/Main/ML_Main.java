package Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import gruppen.GUI_Gruppen;
import gruppen.GUI_New_G;
import kunden.GUI_Kunden;
import kunden.GUI_New;
import mitarbeiter.GUI_Mitarbeiter;
import mitarbeiter.GUI_New_M;

public class ML_Main implements MouseListener {

	JLabel lbl;
	JDesktopPane panel;
	Border ub = BorderFactory.createLoweredBevelBorder();
	Border lb = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	Object [] k_o_m = {"Kunde","Mitarbeiter","Gruppe"};
	
	
	public ML_Main(JLabel lbl,JDesktopPane panel) {
		
		this.lbl = lbl;
		this.panel = panel;
	}
public ML_Main(JLabel lbl) {
		
		this.lbl = lbl;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (lbl.getToolTipText() == "Neu" & Var.isBtn_new() == false & Var.isBtn_new_m() == false) {
			
			int i = JOptionPane.showOptionDialog(panel, "Was soll neu angelegt werden?", "Neu", JOptionPane.YES_NO_OPTION, 1, null, k_o_m, k_o_m[0]);
			
			if (i == 0) {
		panel.add(new GUI_New());
			Var.setBtn_new(true);
			}
			else if(i == 1) {
				panel.add(new GUI_New_M());
				Var.setBtn_new_m(true);
			}
			else if (i == 2) {
				panel.add(new GUI_New_G());
				Var.setBtn_new_g(true);
			}
		}
			
//		if (lbl.getToolTipText() == "Kunde bearbeiten" & Var.isBtn_edit() == false) {
//			
//			int i = Integer.parseInt(JOptionPane.showInputDialog("Bitte die ID des Kunden eingeben"));
//			panel.add(new GUI_Details_K(i));
//			Var.setBtn_edit(true);
//		}
		if (lbl.getToolTipText() == "Kunden" & Var.isBtn_customer() == false) {
		
			panel.add(new GUI_Kunden(panel));
			Var.setBtn_customer(true);			
		}
		if (lbl.getToolTipText() == "Mitarbeiter" & Var.isBtn_worker() == false) {
			
			panel.add(new GUI_Mitarbeiter(panel));
			Var.setBtn_worker(true);			
		}
		if (lbl.getToolTipText() == "Einstellungen" & Var.isBtn_settings() == false) {
			panel.add(new GUI_Settings());
					Var.setBtn_settings(true);
			}
		if (lbl.getToolTipText() == "Gruppen" & Var.isBtn_group() == false) {
			panel.add(new GUI_Gruppen(panel));
			Var.setBtn_group(true);
		}

		}

	@Override
	public void mouseEntered(MouseEvent e) {

		
			
			lbl.setBorder(lb);
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		lbl.setBorder(null);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		lbl.setBorder(ub);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
			lbl.setBorder(lb);
		
	}

}
