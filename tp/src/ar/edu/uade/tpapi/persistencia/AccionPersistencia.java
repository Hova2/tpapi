package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Accion;

public class AccionPersistencia extends AdministradorPersistencia {

	private static AccionPersistencia instancia;
	
	public AccionPersistencia() {
	}

	public static AccionPersistencia getInstance(){
		if (instancia==null){
			instancia=new AccionPersistencia();
		}
		return instancia;
	}
	
	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long ultimoNumero(){
		return 0;
	}
	
	public Vector<Accion> recuperarAccionesReclamo(long nroReclamo){
		Connection con = null;
		PreparedStatement sta = null;
		Vector<Accion> accionesTmp = new Vector<Accion>();
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("select * from tpapi.dbo.Accion where nroReclamo=?");
			sta.setLong(1, nroReclamo);
			ResultSet res = sta.executeQuery();
			while(res.next()){
				java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(2).getTime());
				Accion accionTmp = new Accion(res.getLong(1), fechaAltaTmp, res.getString(3));
				accionesTmp.add(accionTmp);
					
			} 
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
		return accionesTmp;
	}

}
