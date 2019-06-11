package Main;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					//läd die Mysql Verbindungsinfos aus der Properties file in die Variablen der Var Klasse.
					Var.setProbs();
					//startet die Main GUI
					Main_GUI window = new Main_GUI();
					
					
									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
