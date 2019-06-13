package kunden;


import java.sql.*;

import Main.Var;

public class MySQLZugriff {
	
	protected Statement stmt;              
	public ResultSet rs;
	public ResultSet rs_g;
	Connection con;
	
	//Stellt Verbindung mit der Datenbank her somit können alles informationen der Tablle kunden gehohlt werden 
	public MySQLZugriff(String table) {

		
		try {

			
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(Var.getHost());
			String url     = "jdbc:mysql://"+Var.getHost()+":"+Var.getPort()+"/"+Var.getDb();  
			System.out.println(url);
			con = DriverManager.getConnection(url,Var.getUser(),Var.getPw());        
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM "+table);
			
			
		} catch (Exception e) {
			System.out.println("Fail"+e);
		}
	}
	
	//Stellt Verbindung mit der Datenbank her gibt aber nur informationen vom Kunden mit der ID = übergebene int.
public MySQLZugriff(int id,String db) {

	
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(Var.getHost());
			String url     = "jdbc:mysql://"+Var.getHost()+":"+Var.getPort()+"/"+Var.getDb();  
			System.out.println(url);
			con = DriverManager.getConnection(url,Var.getUser(),Var.getPw());        
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM "+db+" WHERE(ID ="+id+");");
			rs_g = stmt.executeQuery("SELECT * FROM "+db+" WHERE(ID ="+id+");");
			

			
		} catch (Exception e) {
			System.out.println("Fail"+e);
		}
	}

}
