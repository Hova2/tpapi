package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.ReclamoZona;

public class ReclamoZonaPersistencia extends AdministradorPersistencia {

	private static ReclamoZonaPersistencia instancia;
	
	public ReclamoZonaPersistencia() {
	}

	public static ReclamoZonaPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoZonaPersistencia();
	}
	
	@Override
	public void insert(Object o) {
		ReclamoZona reclamoZonaTmp = (ReclamoZona)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("insert into tpapi.dbo.Reclamo (nroReclamo,fechaAlta,fechaCierre,descripcion,estado,dniCliente) values (?,?,?,?,?,?)");
			sta.setLong(1,reclamoZonaTmp.getNroReclamo());
			Date fechaAltaTmp = new java.sql.Date(reclamoZonaTmp.getFechaAlta().getTime());
			sta.setDate(2,fechaAltaTmp);
			sta.setDate(3,null);
			sta.setString(4,reclamoZonaTmp.getDescripcion());
			sta.setInt(5,reclamoZonaTmp.getEstado());
			sta.setLong(6, reclamoZonaTmp.getDniCliente());
			sta.execute();
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

}
