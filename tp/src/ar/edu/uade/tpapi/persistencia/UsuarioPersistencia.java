package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Usuario;

public class UsuarioPersistencia extends AdministradorPersistencia {

	private static UsuarioPersistencia instancia;
	
	private UsuarioPersistencia() {
	}
	
	public static UsuarioPersistencia getInstance(){
		if (instancia==null){
			instancia=new UsuarioPersistencia();
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
	public void delete(Object d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario recuperarUsuario(String nombre){
		Usuario usuarioTmp = null;
		Connection con = null;
		PreparedStatement sta = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("select * from tpapi.dbo.Usuario where nombre=?");
			sta.setString(1,nombre);
			ResultSet res = sta.executeQuery();
			while (res.next()){
				long idUsuario = res.getLong(1);
				String nombreUsuario = res.getString(2);
				String password = res.getString(3);
				int rol = res.getInt(4);
				usuarioTmp = new Usuario(idUsuario, nombreUsuario, password, rol);
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
					ConnectionDB.getInstance().realeaseConnection(con);
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}
		return usuarioTmp;
	}
}
