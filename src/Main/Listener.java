package Main;


import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


//Listener der die eingabe in die ToolBar der InternalFrames �berwacht.
public class Listener implements InternalFrameListener
{
	JInternalFrame frame;
	
	public Listener(JInternalFrame frame) {
		
		this.frame = frame;
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
		
		if (frame.getTitle() == "Kunden") {
			
			Var.setBtn_customer(false);
		}
		if (frame.getToolTipText()== "Info") {
			
			Var.setBtn_edit(false);
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