package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;
import ar.edu.uade.tpapi.modelo.Factura;
import ar.edu.uade.tpapi.modelo.ItemFactura;
import ar.edu.uade.tpapi.modelo.Producto;

public class FacturaPersistencia extends AdministradorPersistencia {

	private static FacturaPersistencia instancia;
	
	private FacturaPersistencia() {
	}

	public static FacturaPersistencia getInstance(){
		if (instancia==null){
			instancia=new FacturaPersistencia();
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
	
	public Factura recuperarFactura(long nroFactura){
		Connection con = null;
		PreparedStatement sta = null;
		Factura facturaTmp=null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("select * from tpapi.dbo.Factura where nroFactura=?");
			sta.setLong(1,nroFactura);
			ResultSet res = sta.executeQuery();
			long nroFac = 0;
			java.util.Date fechaTmp = null;
			float total = 0;
			long nroClienteTmp = 0;
			while (res.next()){
				nroFac = res.getLong(1);
				fechaTmp = new java.util.Date(res.getDate(2).getTime());
				total = res.getFloat(3);
				nroClienteTmp = res.getLong(4);
			}
			sta.close();
			Cliente clienteTmp = Cliente.recuperarCliente(nroClienteTmp);
			Vector<ItemFactura> itemsFacturaTmp = this.recuperarItemsFactura(nroFactura);
			facturaTmp = new Factura(nroFac, fechaTmp, total, clienteTmp, itemsFacturaTmp);
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		return facturaTmp;
	}
	
	private Vector<ItemFactura> recuperarItemsFactura(long nroFactura){
		Connection con = null;
		PreparedStatement sta = null;
		Vector<ItemFactura> itemsFacturaTmp = null;
		try{
			con = ConnectionDB.getInstance().connect();
			sta = con.prepareStatement("select * from tpapi.dbo.ItemFactura where nroFactura=?");
			sta.setLong(1,nroFactura);
			ResultSet res = sta.executeQuery();
			itemsFacturaTmp = new Vector<ItemFactura>();
			class ProdCant{
				long codProd;
				int cantidad;
			}
			Vector<ProdCant> productosCantidad = new Vector<ProdCant>(); 
			while (res.next()){
				ProdCant prodcantTmp = new ProdCant();
				prodcantTmp.codProd = res.getLong(2);
				prodcantTmp.cantidad = res.getInt(3);
				productosCantidad.add(prodcantTmp);
			}
			for(int i=0;i<productosCantidad.size();i++){
				Producto productoTmp = Producto.recuperarProducto(productosCantidad.get(i).codProd);
				int cantidad = productosCantidad.get(i).cantidad;
				ItemFactura itemFacturaTmp = new ItemFactura(productoTmp, cantidad);
				itemsFacturaTmp.add(itemFacturaTmp);
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
		return itemsFacturaTmp;
	}
}
