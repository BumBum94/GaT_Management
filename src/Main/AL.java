package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class AL implements KeyListener{

	JTextField field;
	int x = 0;
	
	public AL(JTextField field) {
		
		this.field = field;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		x = field.getText().length();
		System.out.println(x);
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			
			if (x == 2 || x== 5 ) {
				x--;
			}
			
		}
		if (x == 2|| x ==5) {
			
			field.setText(field.getText()+".");
		}
		
		char c = e.getKeyChar();
		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
			
				e.consume();
				
		}
		
	}
	
	

}
