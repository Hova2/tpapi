package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

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
			con=ConnectionDB.getInstance().connect();
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
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
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
						reclamoZonaTmp.getEstado(), reclamoZonaTmp.getCliente().getDniCliente());
			}else if (o instanceof ReclamoCantidad){
				ReclamoCantidad reclamoCantidadTmp = (ReclamoCantidad)o;
				this.insertReclamo(reclamoCantidadTmp.getNroReclamo(), reclamoCantidadTmp.getFechaAlta(), reclamoCantidadTmp.getDescripcion(), 
						reclamoCantidadTmp.getEstado(), reclamoCantidadTmp.getCliente().getDniCliente());
				Connection con = ConnectionDB.getInstance().connect();
				for(int i=0;i<reclamoCantidadTmp.getProductos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ItemProductoReclamo (nroIteProdRec,codigoProd,cantidad) values (?,?,?)");
					sta.setLong(1, reclamoCantidadTmp.getNroReclamo());
					sta.setLong(2, reclamoCantidadTmp.getProductos().get(i).getProducto().getCodigo());
					sta.setFloat(3, reclamoCantidadTmp.getProductos().get(i).getCantidad());
					sta.execute();
					sta.close();
				}
				con.close();
			}else if (o instanceof ReclamoFacturacion){
				ReclamoFacturacion reclamoFacturacionTmp = (ReclamoFacturacion)o;
				this.insertReclamo(reclamoFacturacionTmp.getNroReclamo(), reclamoFacturacionTmp.getFechaAlta(), reclamoFacturacionTmp.getDescripcion(), 
						reclamoFacturacionTmp.getEstado(), reclamoFacturacionTmp.getCliente().getDniCliente());
				Connection con = ConnectionDB.getInstance().connect();
				for(int i=0;i<reclamoFacturacionTmp.getFacturas().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.FacturaReclamo (nroReclamo,nroFactura) values (?,?)");
					sta.setLong(1, reclamoFacturacionTmp.getNroReclamo());
					sta.setLong(2, reclamoFacturacionTmp.getFacturas().get(i).getNroFactura());
					sta.execute();
					sta.close();
				}
				con.close();
			}else if (o instanceof ReclamoFaltante){
				ReclamoFaltante reclamoFaltanteTmp = (ReclamoFaltante)o;
				this.insertReclamo(reclamoFaltanteTmp.getNroReclamo(), reclamoFaltanteTmp.getFechaAlta(), reclamoFaltanteTmp.getDescripcion(), 
						reclamoFaltanteTmp.getEstado(), reclamoFaltanteTmp.getCliente().getDniCliente());
				Connection con = ConnectionDB.getInstance().connect();
				for(int i=0;i<reclamoFaltanteTmp.getProductos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ItemProductoReclamo (nroIteProdRec,codigoProd,cantidad) values (?,?,?)");
					sta.setLong(1, reclamoFaltanteTmp.getNroReclamo());
					sta.setLong(2, reclamoFaltanteTmp.getProductos().get(i).getProducto().getCodigo());
					sta.setFloat(3, reclamoFaltanteTmp.getProductos().get(i).getCantidad());
					sta.execute();
					sta.close();
				}
				con.close();
			}else{
				ReclamoProducto reclamoProductoTmp = (ReclamoProducto)o;
				Connection con = ConnectionDB.getInstance().connect();
				for(int i=0;i<reclamoProductoTmp.getReclamos().size();i++){
					PreparedStatement sta = con.prepareStatement("insert into tpapi.dbo.ReclamoProducto (nroReclamoProducto,nroReclamo) values (?,?)");
					sta.setLong(1, reclamoProductoTmp.getNroReclamo());
					sta.setLong(1, reclamoProductoTmp.getReclamos().get(i).getNroReclamo());
					sta.execute();
					sta.close();
				}
				con.close();
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
	
	private void insertReclamo(long nroReclamo, Date fechaAlta, String descripcion, int estado, long dniCliente ){
		Connection con=null;
		PreparedStatement sta=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("insert into tpapi.dbo.Reclamo (nroReclamo,fechaAlta,fechaCierre,descripcion,estado,dniCliente) values (?,?,?,?,?,?)");
			sta.setLong(1,nroReclamo);
			java.sql.Date fechaAltaTmp = new java.sql.Date(fechaAlta.getTime());
			sta.setDate(2,fechaAltaTmp);
			sta.setDate(3,null);
			sta.setString(4,descripcion);
			sta.setInt(5,estado);
			sta.setLong(6,dniCliente);
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
}
