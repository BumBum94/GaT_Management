package Main;


import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import kunden.GUI_Kunden;


//Listener der die eingabe in die ToolBar der InternalFrames überwacht.
public class Listener implements InternalFrameListener
{
	JInternalFrame frame,pan;
	JDesktopPane jpan;
	
	public Listener(JInternalFrame frame) {
		
		this.frame = frame;
	}
	
	public Listener(JInternalFrame frame,JInternalFrame pan) {
		this.pan = pan;
		this.frame = frame;
	}
	public Listener(JInternalFrame frame,JInternalFrame pan,JDesktopPane jpan) {
		this.pan = pan;
		this.frame = frame;
		this.jpan = jpan;
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		
		if (frame.getTitle()== "Neuer Kunde") {
			
			Var.setBtn_new(false);
		}
		if (frame.getTitle()== "Neuer Mitarbeiter") {
			
			Var.setBtn_new_m(false);
		}
		if (frame.getTitle()== "Neue Gruppe") {
			
			Var.setBtn_new_g(false);
		}
		
		if (frame.getTitle() == "Kunden") {
			
			Var.setBtn_customer(false);
		}
		if (frame.getTitle() == "Mitarbeiter") {
			
			Var.setBtn_worker(false);
		}
		if (frame.getTitle() == "Gruppen") {
			
			Var.setBtn_group(false);
		}
		if (frame.getToolTipText()== "Info") {
			
			Var.setBtn_edit(false);
			try {
				pan.setIcon(false);
				jpan.remove(pan);
				jpan.add(new GUI_Kunden(jpan));
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

}