package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Producto;

public class ProductoPersistencia extends AdministradorPersistencia {

	private static ProductoPersistencia instancia;
	
	private ProductoPersistencia(){
	}
	
	public static ProductoPersistencia getInstance(){
		if (instancia==null){
			instancia=new ProductoPersistencia();
		}
		return instancia;
	}
	
	@Override
	public void insert(Object o) {
		Producto prod = (Producto)o;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("insert into tpapi.dbo.Producto (codigo,titulo,descripcion,precio,activo) values (?,?,?,?,?)");
			sta.setLong(1,prod.getCodigo());
			sta.setString(2,prod.getTitulo());
			sta.setString(3,prod.getDescripcion());
			sta.setFloat(4,prod.getPrecio());
			sta.setBoolean(5,prod.isActivo());
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
	
	public Producto recuperarProducto(long codigo){
		Producto productoTmp=null;
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("select * from tpapi.dbo.Producto where codigo=?");
			sta.setLong(1,codigo);
			ResultSet res = sta.executeQuery();
			while (res.next()){
				long cod = res.getLong(1);
				String titulo = res.getString(2);
				String des = res.getString(3);
				float pres = res.getFloat(4);
				boolean act = res.getBoolean(5);
				productoTmp = new Producto(cod, titulo, des, pres, act);
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
		return productoTmp;
	}
}
