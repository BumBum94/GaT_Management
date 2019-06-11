package mitarbeiter;


import java.sql.*;

import Main.Var;

public class MySQLZugriff {
	
	Statement stmt;       
	public ResultSet rs;
	Connection con;
	
	//Stellt Verbindung mit der Datenbank her somit können alles informationen der Tablle kunden gehohlt werden 
	public MySQLZugriff() {

		
		try {

			
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(Var.getHost());
			String url     = "jdbc:mysql://"+Var.getHost()+":"+Var.getPort()+"/"+Var.getDb();  
			System.out.println(url);
			con = DriverManager.getConnection(url,Var.getUser(),Var.getPw());        
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT name,vorname,strasse,hausnr,plz, ort, telnr, email, bezeichnung, geschlecht, anmerkung, bild, id FROM mitarbeiter");
			
			
		} catch (Exception e) {
			System.out.println("Fail"+e);
		}
	}
	
	//Stellt Verbindung mit der Datenbank her gibt aber nur informationen vom Kunden mit der ID = übergebene int.
public MySQLZugriff(int id) {

	
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(Var.getHost());
			String url     = "jdbc:mysql://"+Var.getHost()+":"+Var.getPort()+"/"+Var.getDb();  
			System.out.println(url);
			con = DriverManager.getConnection(url,Var.getUser(),Var.getPw());        
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM mitarbeiter WHERE(ID ="+id+");");
			

			
		} catch (Exception e) {
			System.out.println("Fail"+e);
		}
	}

}
