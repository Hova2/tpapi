package ar.edu.uade.tpapi.persistencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class ConnectionDB {

	private static ConnectionDB instancia;
	private Vector <Connection> connections = new Vector<Connection>();
	protected int cantCon = 5;
	private String jdbc;
	private String server;
	private String user;
	private String password;
	
	private ConnectionDB(){
		this.getConfiguration();
		for (int i = 0; i < cantCon; i++)
			connections.add(this.createConnection());
	}
	
	public static ConnectionDB getInstance(){
		if (instancia==null){
			instancia=new ConnectionDB();
		}
		return instancia;
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
			Connection con = DriverManager.getConnection (dbConnectString, user, password);
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
	
	public Connection getConnection(){
		Connection con = null;
		if (connections.size() > 0)
			con = connections.remove(0);
		else{
			con = this.createConnection();
		}
		return con;
	}
	
	public void realeaseConnection(Connection con){
		connections.add(con);
	}
	
	public void closeConnections(){
		try{
			for (int i=0; i<connections.size();i++){
				connections.get(i).close();
			}
		}
		catch(Exception e){
			System.out.println("Mensaje Error: " + e.getMessage());
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}
}