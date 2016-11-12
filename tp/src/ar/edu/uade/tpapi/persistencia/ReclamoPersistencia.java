package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Accion;
import ar.edu.uade.tpapi.modelo.Cliente;
import ar.edu.uade.tpapi.modelo.Factura;
import ar.edu.uade.tpapi.modelo.ItemProductoReclamo;
import ar.edu.uade.tpapi.modelo.Producto;
import ar.edu.uade.tpapi.modelo.Reclamo;
import ar.edu.uade.tpapi.modelo.ReclamoCantidad;
import ar.edu.uade.tpapi.modelo.ReclamoFacturacion;
import ar.edu.uade.tpapi.modelo.ReclamoFaltante;
import ar.edu.uade.tpapi.modelo.ReclamoProducto;
import ar.edu.uade.tpapi.modelo.ReclamoZona;

public class ReclamoPersistencia extends AdministradorPersistencia{

	private static ReclamoPersistencia instancia;
	
	private ReclamoPersistencia() {
	}

	public static ReclamoPersistencia getInstance(){
		if (instancia==null){
			instancia=new ReclamoPersistencia();
		}
		return instancia;
	}
	
	public long ultimoNumero(){
		long rta = 0;
		Connection con=null;
		Statement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta=con.createStatement();
			ResultSet res = sta.executeQuery("select top 1 nroReclamo from tpapi.dbo.Reclamo order by nroReclamo desc");
			rta = res.next() ? res.getLong(1) : -1;
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
			catch (Exception e){
				System.out.println(e);
			}
		}
		return rta;
	}

	@Override
	public void insert(Object o) {
		try{
			if (o instanceof ReclamoZona){
				ReclamoZona reclamoZonaTmp = (ReclamoZona)o;
				this.insertReclamo(reclamoZonaTmp.getNroReclamo(), reclamoZonaTmp.getFechaAlta(), reclamoZonaTmp.getDescripcion(), 
						reclamoZonaTmp.getEstado(), reclamoZonaTmp.getCliente().getDniCliente(), reclamoZonaTmp.getTipoReclamo());
			}else if (o instanceof ReclamoCantidad){
				ReclamoCantidad reclamoCantidadTmp = (ReclamoCantidad)o;
				this.insertReclamo(reclamoCantidadTmp.getNroReclamo(), reclamoCantidadTmp.getFechaAlta(), reclamoCantidadTmp.getDescripcion(), 
						reclamoCantidadTmp.getEstado(), reclamoCantidadTmp.getCliente().getDniCliente(),reclamoCantidadTmp.getTipoReclamo());
				Connection con = ConnectionDB.getInstance().getConnection();
				for(int i=0;i<reclamoCantidadTmp.getProductos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ItemProductoReclamo (nroIteProdRec,codigoProd,cantidad) values (?,?,?)");
					sta.setLong(1, reclamoCantidadTmp.getNroReclamo());
					sta.setLong(2, reclamoCantidadTmp.getProductos().get(i).getProducto().getCodigo());
					sta.setFloat(3, reclamoCantidadTmp.getProductos().get(i).getCantidad());
					sta.execute();
					sta.close();
				}
				ConnectionDB.getInstance().realeaseConnection(con);
			}else if (o instanceof ReclamoFacturacion){
				ReclamoFacturacion reclamoFacturacionTmp = (ReclamoFacturacion)o;
				this.insertReclamo(reclamoFacturacionTmp.getNroReclamo(), reclamoFacturacionTmp.getFechaAlta(), reclamoFacturacionTmp.getDescripcion(), 
						reclamoFacturacionTmp.getEstado(), reclamoFacturacionTmp.getCliente().getDniCliente(),reclamoFacturacionTmp.getTipoReclamo());
				Connection con = ConnectionDB.getInstance().getConnection();
				for(int i=0;i<reclamoFacturacionTmp.getFacturas().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.FacturaReclamo (nroReclamo,nroFactura) values (?,?)");
					sta.setLong(1, reclamoFacturacionTmp.getNroReclamo());
					sta.setLong(2, reclamoFacturacionTmp.getFacturas().get(i).getNroFactura());
					sta.execute();
					sta.close();
				}
				ConnectionDB.getInstance().realeaseConnection(con);
			}else if (o instanceof ReclamoFaltante){
				ReclamoFaltante reclamoFaltanteTmp = (ReclamoFaltante)o;
				this.insertReclamo(reclamoFaltanteTmp.getNroReclamo(), reclamoFaltanteTmp.getFechaAlta(), reclamoFaltanteTmp.getDescripcion(), 
						reclamoFaltanteTmp.getEstado(), reclamoFaltanteTmp.getCliente().getDniCliente(), reclamoFaltanteTmp.getTipoReclamo());
				Connection con = ConnectionDB.getInstance().getConnection();
				for(int i=0;i<reclamoFaltanteTmp.getProductos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ItemProductoReclamo (nroIteProdRec,codigoProd,cantidad) values (?,?,?)");
					sta.setLong(1, reclamoFaltanteTmp.getNroReclamo());
					sta.setLong(2, reclamoFaltanteTmp.getProductos().get(i).getProducto().getCodigo());
					sta.setFloat(3, reclamoFaltanteTmp.getProductos().get(i).getCantidad());
					sta.execute();
					sta.close();
				}
				ConnectionDB.getInstance().realeaseConnection(con);
			}else{
				ReclamoProducto reclamoProductoTmp = (ReclamoProducto)o;
				Connection con = ConnectionDB.getInstance().getConnection();
				for(int i=0;i<reclamoProductoTmp.getReclamos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ReclamoProducto (nroReclamoProducto,nroReclamo) values (?,?)");
					sta.setLong(1, reclamoProductoTmp.getNroReclamo());
					sta.setLong(1, reclamoProductoTmp.getReclamos().get(i).getNroReclamo());
					sta.execute();
					sta.close();
				}
				ConnectionDB.getInstance().realeaseConnection(con);
			}
		}
		catch (Exception e){
			System.out.println(e);
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
	
	public void insertarAccion(Accion accion, long nroReclamo){
		Connection con = null;
		PreparedStatement sta = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("insert into tpapi.dbo.Accion (fechaAlta,detalle,nroReclamo) values (?,?,?)");
			java.sql.Date fechaAltaTmp = new java.sql.Date(accion.getFechaAlta().getTime());
			sta.setDate(1,fechaAltaTmp);
			sta.setString(2,accion.getDetalle());
			sta.setLong(3,nroReclamo);
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
	
	public void cambiarEstado(int estado, long nroReclamo){
		Connection con = null;
		PreparedStatement sta = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("update tpapi.dbo.Reclamo set estado=? where nroReclamo=?");
			sta.setInt(1, estado);
			sta.setLong(2, nroReclamo);
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
			
	public Reclamo recuperarReclamo(long nroReclamo){
		Reclamo reclamoTmp = null;
		Connection con = null;
		PreparedStatement sta = null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("select * from tpapi.dbo.Reclamo where nroReclamo=?");
			sta.setLong(1,nroReclamo);
			ResultSet res = sta.executeQuery();
			while (res.next()){
				if(res.getInt(7) == 0){
					java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(2).getTime());
					java.util.Date fechaCierreTmp = null;
					if(res.getDate(3) != null){
						fechaCierreTmp = new java.util.Date(res.getDate(3).getTime());
					}
					Cliente clienteTmp = Cliente.recuperarCliente(res.getLong(6));
					Vector<Accion> accionesTmp = this.recuperarAccionesReclamo(res.getLong(1));
					reclamoTmp = new ReclamoZona(res.getLong(1), fechaAltaTmp, fechaCierreTmp, res.getString(4), res.getInt(5), 
							res.getInt(7), accionesTmp, clienteTmp);
				}
				if(res.getInt(7) == 1){
					java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(2).getTime());
					java.util.Date fechaCierreTmp = null;
					if(res.getDate(3) != null){
						fechaCierreTmp = new java.util.Date(res.getDate(3).getTime());
					}
					Cliente clienteTmp = Cliente.recuperarCliente(res.getLong(6));
					Vector<Accion> accionesTmp = this.recuperarAccionesReclamo(res.getLong(1));
					Vector<ItemProductoReclamo> itemsProductosReclamosTmp = new Vector<ItemProductoReclamo>();
					Connection con2 = ConnectionDB.getInstance().getConnection();
					PreparedStatement sta2 = con2.prepareStatement("select * from tpapi.dbo.ItemProductoReclamo where nroIteProdRec=?");
					sta2.setLong(1, nroReclamo);
					ResultSet res2 = sta2.executeQuery();
					while(res2.next()){
						Producto productoTmp = Producto.recuperarProducto(res2.getLong(2));
						int cantidadTmp = res2.getInt(3);
						ItemProductoReclamo itemProductoReclamoTmp = new ItemProductoReclamo(productoTmp, cantidadTmp);
						itemsProductosReclamosTmp.add(itemProductoReclamoTmp);
					}
					
					reclamoTmp = new ReclamoCantidad(res.getLong(1), fechaAltaTmp, fechaCierreTmp, clienteTmp, res.getString(4), res.getInt(5), 
							res.getInt(7), accionesTmp, itemsProductosReclamosTmp);
				}
				if(res.getInt(7) == 2){
					java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(2).getTime());
					java.util.Date fechaCierreTmp = null;
					if(res.getDate(3) != null){
						fechaCierreTmp = new java.util.Date(res.getDate(3).getTime());
					}
					Cliente clienteTmp = Cliente.recuperarCliente(res.getLong(6));
					Vector<Accion> accionesTmp = this.recuperarAccionesReclamo(res.getLong(1));
					Vector<ItemProductoReclamo> itemsProductosReclamosTmp = new Vector<ItemProductoReclamo>();
					Connection con2 = ConnectionDB.getInstance().getConnection();
					PreparedStatement sta2 = con2.prepareStatement("select * from tpapi.dbo.ItemProductoReclamo where nroIteProdRec=?");
					sta2.setLong(1, nroReclamo);
					ResultSet res2 = sta2.executeQuery();
					while(res2.next()){
						Producto productoTmp = Producto.recuperarProducto(res2.getLong(2));
						int cantidadTmp = res2.getInt(3);
						ItemProductoReclamo itemProductoReclamoTmp = new ItemProductoReclamo(productoTmp, cantidadTmp);
						itemsProductosReclamosTmp.add(itemProductoReclamoTmp);
					}
					reclamoTmp = new ReclamoFaltante(res.getLong(1), fechaAltaTmp, fechaCierreTmp, clienteTmp, res.getString(4), res.getInt(5), 
							res.getInt(7), accionesTmp, itemsProductosReclamosTmp);
				}
				
				if(res.getInt(7) == 3){
					java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(2).getTime());
					java.util.Date fechaCierreTmp = null;
					if(res.getDate(3) != null){
						fechaCierreTmp = new java.util.Date(res.getDate(3).getTime());
					}
					Cliente clienteTmp = Cliente.recuperarCliente(res.getLong(6));
					Vector<Accion> accionesTmp = this.recuperarAccionesReclamo(res.getLong(1));
					Vector<Factura> facturasTmp = new Vector<Factura>();
					Connection con2 = ConnectionDB.getInstance().getConnection();
					PreparedStatement sta2 = con2.prepareStatement("select * from tpapi.dbo.FacturaReclamo where nroReclamo=?");
					sta2.setLong(1, nroReclamo);
					ResultSet res2 = sta2.executeQuery();
					while(res2.next()){
						Factura facturaTmp = Factura.recuperarFactura(res2.getLong(2));
						facturasTmp.add(facturaTmp);
					}
					reclamoTmp = new ReclamoFacturacion(res.getLong(1), fechaAltaTmp, fechaCierreTmp, clienteTmp, res.getString(4), res.getInt(5), 
							res.getInt(7), accionesTmp, facturasTmp);
				}
				
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
		return reclamoTmp;
	}
	
	public Vector<Reclamo> recuperarReclamos(){
		Connection con = null;
		Statement sta = null;
		Vector<Reclamo> reclamosTmp = new Vector<Reclamo>();
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.createStatement();
			ResultSet res = sta.executeQuery("select * from tpapi.dbo.Reclamo");
			while(res.next()){
				reclamosTmp.add(this.recuperarReclamo(res.getLong(1)));
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
		return reclamosTmp;
	}
	
	private void insertReclamo(long nroReclamo, Date fechaAlta, String descripcion, int estado, long dniCliente, int tipoReclamo ){
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("insert into tpapi.dbo.Reclamo (nroReclamo,fechaAlta,fechaCierre,descripcion,estado,dniCliente,tipoReclamo) values (?,?,?,?,?,?,?)");
			sta.setLong(1,nroReclamo);
			java.sql.Date fechaAltaTmp = new java.sql.Date(fechaAlta.getTime());
			sta.setDate(2,fechaAltaTmp);
			sta.setDate(3,null);
			sta.setString(4,descripcion);
			sta.setInt(5,estado);
			sta.setLong(6,dniCliente);
			sta.setInt(7,tipoReclamo);
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
	
	private Vector<Accion> recuperarAccionesReclamo(long nroReclamo){
		Connection con = null;
		PreparedStatement sta = null;
		Vector<Accion> accionesTmp = new Vector<Accion>();
		try{
			con = ConnectionDB.getInstance().getConnection();
			sta = con.prepareStatement("select * from tpapi.dbo.Accion where nroReclamo=?");
			sta.setLong(1, nroReclamo);
			ResultSet res = sta.executeQuery();
			while(res.next()){
				java.util.Date fechaAltaTmp = new java.util.Date(res.getDate(1).getTime());
				Accion accionTmp = new Accion(fechaAltaTmp, res.getString(2));
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
					ConnectionDB.getInstance().realeaseConnection(con);
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}
		return accionesTmp;
	}
	
	public Vector<Cliente> rankingClientes(){
		Connection con = null;
		PreparedStatement sta = null;
		Vector<Cliente> clientesTmp = new Vector<Cliente>();
		sta = con.prepareStatement("select top 5 dniCliente,count(dniCliente) AS cantidadReclamoCliente from tpapi.dbo.Reclamo group by dniCliente order by cantidadReclamoCliente DESC");
	}
}
