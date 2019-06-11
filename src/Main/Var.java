package Main;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
//classe Mit Static Variablen die in im ganzen Programm genutzt werden zu um zu verhinden das die selbe GUI mehrfach geöffnet wird
public class Var {

	static boolean btn_new = false;
	static boolean btn_new_m = false;
	static boolean btn_customer = false;
	static boolean btn_settings = false;
	static boolean btn_edit = false;
	static boolean btn_worker = false;
	static File propertiesFile = new File("config/config.properties");
	static Properties properties = new Properties();
	static String host; 
	
	
	public static boolean isBtn_worker() {
		return btn_worker;
	}

	public static void setBtn_worker(boolean btn_worker) {
		Var.btn_worker = btn_worker;
	}

	public static boolean isBtn_new_m() {
		return btn_new_m;
	}

	public static void setBtn_new_m(boolean btn_new_m) {
		Var.btn_new_m = btn_new_m;
	}

	public static boolean isBtn_edit() {
		return btn_edit;
	}

	public static void setBtn_edit(boolean btn_edit) {
		Var.btn_edit = btn_edit;
	}

	
	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		Var.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		Var.port = port;
	}

	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		Var.db = db;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Var.user = user;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		Var.pw = pw;
	}

	static String port;
	static String db;
	static String user;
	static String pw;
	
	//methode zu auslesen der .properties dateii und zum füllen der TXT felder für die Einstellungen.
	public static void setProbs() {
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(propertiesFile))) {
			  properties.load(bis);
			} catch (Exception ex) {
			  //
			}
		
		host = properties.getProperty("host");
		port = properties.getProperty("port");
		db = properties.getProperty("database");
		user = properties.getProperty("user");
		pw = String.valueOf(properties.getProperty("password"));
		
		System.out.println(host+" "+port+" "+db+" "+user+" "+pw);
		
	}
	
	public static boolean isBtn_settings() {
		return btn_settings;
	}

	public static void setBtn_settings(boolean btn_settings) {
		Var.btn_settings = btn_settings;
	}

	public static boolean isBtn_customer() {
		return btn_customer;
	}

	public static void setBtn_customer(boolean btn_customer) {
		Var.btn_customer = btn_customer;
	}

	public static boolean isBtn_new() {
		return btn_new;
	}

	public static void setBtn_new(boolean btn_new) {
		Var.btn_new = btn_new;
	}
	
	
	
	
	
}
