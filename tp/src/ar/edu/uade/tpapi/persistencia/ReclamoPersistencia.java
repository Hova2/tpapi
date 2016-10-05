package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;

public class ReclamoPersistencia {

	private static ReclamoPersistencia instancia;
	
	private ReclamoPersistencia() {
	}

	public static ReclamoPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoPersistencia();
	}
	
	public long ultimoNumero(){
		long rta = 0;
		Connection con=null;
		Statement sta=null;
		try{
			con=ConnectionDB.getInstance().connect();
			sta=con.createStatement();
			ResultSet res = sta.executeQuery("select top 1 nroReclamo from tpapi.dbo.Reclamo order by nroReclamo desc");
			res.next();
			rta =res.getLong(1);
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally{
			try{
				if(sta!=null)
					sta.close();
			}
			catch (SQLException e){}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		return rta;
	}
}
