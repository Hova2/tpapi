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
		if (instancia==null){
			instancia=new ClientePersistencia();
		}
		return instancia;
	}
	
	@Override
	public void insert(Object o) {
		Cliente cli = (Cliente)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("insert into tpapi.dbo.Cliente (dniCliente,nombre,domicilio,telefono,mail,activo) values (?,?,?,?,?,?)");
			sta.setLong(1,cli.getDniCliente());
			sta.setString(2,cli.getNombre());
			sta.setString(3,cli.getDomicilio());
			sta.setString(4,cli.getTelefono());
			sta.setString(5,cli.getMail());
			sta.setBoolean(6,cli.isActivo());
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
					ConnectionDB.getInstance().realeaseConnection(con);
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}
	}
	
	/*public long insertGetId(Object o) {
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
	}*/

	@Override
	public void update(Object o) {
		Cliente cli = (Cliente)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("update tpapi.dbo.Cliente set nombre=?,domicilio=?,telefono=?,mail=? where dniCliente=?");
			sta.setString(1,cli.getNombre());
			sta.setString(2,cli.getDomicilio());
			sta.setString(3,cli.getTelefono());
			sta.setString(4,cli.getMail());
			sta.setLong(5, cli.getDniCliente());
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
					ConnectionDB.getInstance().realeaseConnection(con);
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void delete(Object o) {
		Cliente cli = (Cliente)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("update tpapi.dbo.Cliente set activo='false' where dniCliente=?");
			sta.setLong(1, cli.getDniCliente());
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
					ConnectionDB.getInstance().realeaseConnection(con);
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}
	}

	/*@Override
	public void delete(Object o) {
		Cliente cli = (Cliente)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("delete from tpapi.dbo.Clientes where dniCliente=?");
			sta.setLong(1,cli.getDniCliente());
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
		
	}*/

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Vector<Cliente> selectAll(){
		Vector<Cliente> rta = null;
		Connection con=null;
		Statement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta=con.createStatement();
			rta=new Vector<Cliente>();
			ResultSet res = sta.executeQuery("select * from tpapi.dbo.Cliente");
			while (res.next()){
				long dniCliente=res.getLong(1);
				String nom=res.getString(2);
				String dom=res.getString(3);
				String tel=res.getString(4);
				String mail=res.getString(5);
				boolean activo=res.getBoolean(6);
				Cliente clienteTmp = new Cliente(dniCliente, nom, dom, tel, mail, activo);
				rta.add(clienteTmp);
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
		return rta;
	}
	
	public Cliente recuperarCliente(long dniCliente){
		Cliente clienteTmp=null;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("select * from tpapi.dbo.Cliente where dniCliente=?");
			sta.setLong(1,dniCliente);
			ResultSet res = sta.executeQuery();
			while (res.next()){
				long dniCli=res.getLong(1);
				String nom=res.getString(2);
				String dom=res.getString(3);
				String tel=res.getString(4);
				String mail=res.getString(5);
				boolean act=res.getBoolean(6);
				clienteTmp=new Cliente(dniCli, nom, dom, tel, mail,act);
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
		return clienteTmp;
	}
}