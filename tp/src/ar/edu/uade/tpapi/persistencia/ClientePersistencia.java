package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;

public class ClientePersistencia extends AdministradorPersistencia{

	private static ClientePersistencia instancia;
	
	
	private ClientePersistencia(){
		
	}
	
	public static ClientePersistencia getInstance(){
		return (instancia!=null) ? instancia : new ClientePersistencia();
	}
	
	public long insertGetId(Object o) {
		Cliente cli = (Cliente)o;
		Connection con=null;
		PreparedStatement s=null;
		long resultado=-1;
		try{
			con = ConnectionDB.getInstance().connect();
			s = con.prepareStatement("insert into tpapi.dbo.Clientes (nombre,domicilio,telefono,mail,activo) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			s.setString(1,cli.getNombre());
			s.setString(2,cli.getDomicilio());
			s.setString(3,cli.getTelefono());
			s.setString(4,cli.getMail());
			s.setBoolean(5,cli.isActivo());
			s.execute();
			ResultSet rs = s.getGeneratedKeys();
			rs.next();
			resultado = rs.getInt(1);	
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally{
			try{
				if(s!=null)
					s.close();
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
		return resultado;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
}
