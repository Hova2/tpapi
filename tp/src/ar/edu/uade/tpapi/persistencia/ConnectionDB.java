package ar.edu.uade.tpapi.persistencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

	private static ConnectionDB instancia;
	private static Connection con;
	private String jdbc;
	private String server;
	private String user;
	private String password;
	
	private ConnectionDB(){
		this.getConfiguration();
	}
	
	private void getConfiguration() {
		
		Properties properties;
	    
	    try {
	    	FileInputStream file = new FileInputStream("ConfigDB.properties");	 
	    	properties = new Properties();
	    	properties.load(file);
	    	file.close();
	    	jdbc = properties.getProperty("jdbc"); 
	    	server = properties.getProperty("server");
	    	user = properties.getProperty("user");
	    	password = properties.getProperty("password");
	    } 
	    catch (Exception e) {
	    	System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
	    }
	}
	
	private Connection createConnection() {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbConnectString = jdbc + server; 
			con = DriverManager.getConnection (dbConnectString, user, password);
			return con;
		}
		catch (SQLException e){
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
			return null;
		}
		catch (Exception ex){
			System.out.println("Mensaje Error: " + ex.getMessage());
			System.out.println("Stack Trace: " + ex.getStackTrace());
			return null;
		}		
	}
	
	public Connection connect() {
		
		try{
			if (con==null){
				con=this.createConnection();
			}
			else if (con.isClosed()){
				con=this.createConnection();
			}
			return con;	
		}
		catch (SQLException e){
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
			return null;
		}
	}
	
	public void closeConnection(){
		try{
			con.close();
		}
		catch(Exception e){
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}
	
	public static ConnectionDB getInstance(){
		if (instancia==null){
			instancia=new ConnectionDB();
		}
		return instancia;
	}
}