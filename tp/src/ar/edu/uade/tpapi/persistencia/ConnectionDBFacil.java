package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBFacil {

		private static ConnectionDBFacil instancia;
		private static Connection con;
				
		private ConnectionDBFacil(){
		}
				
		public Connection connect() {
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection ("jdbc:sqlserver://servidor:1433", "usuario", "password");
				/*Donde dice servidor, hay que poner el nombre del servidor que nos da la profesora. Lo mismo el usuario y la pass*/
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
			
		public void closeConnection(){
			try{
				con.close();
			}
			catch(Exception e){
				System.out.println("Mensaje Error: " + e.getMessage());
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
		}
		
		public static ConnectionDBFacil getInstance(){
			if (instancia==null){
				instancia=new ConnectionDBFacil();
			}
			return instancia;
		}
	}
