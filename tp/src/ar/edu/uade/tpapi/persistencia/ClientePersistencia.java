package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	@Override
	public void insert(Object o) {
		try{
			Cliente cli = (Cliente)o;
			Connection con = ConnectionDB.getInstance().connect();
			PreparedStatement s = con.prepareStatement("insert into tpapi.dbo.Clientes (nombre,domicilio,telefono,mail) values (?,?,?,?)");
			s.setString(1, cli.getNombre());
			s.setString(2,cli.getDomicilio());
			s.setString(3, cli.getTelefono());
			s.setString(4,cli.getMail());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
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
	
	public int getLastId(){
		try{
			Connection con = ConnectionDB.getInstance().connect();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select ident_current ('tpapi.dbo.Clientes')");
			rs.next();
			int last = rs.getInt(1);
			con.close();
			return last;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}

}
