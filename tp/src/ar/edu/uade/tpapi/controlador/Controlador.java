package ar.edu.uade.tpapi.controlador;

import java.util.Vector;

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
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.ItemProductoReclamoView;

public class Controlador {

	private static Controlador instancia;
	private Vector<Cliente> clientes;
	private Vector<Reclamo> reclamos;
	private Vector<Producto> productos;
	private Vector<Factura> facturas;
	
	private Controlador() {
		clientes = new Vector<Cliente>();
		reclamos = new Vector<Reclamo>();
		productos = new Vector<Producto>();
		facturas = new Vector<Factura>();
	}
	
	public static Controlador getInstance(){
		if (instancia==null){
			instancia=new Controlador();
		}
		return instancia;
	}
	
	/* Metodos para la administracion de los clientes */
	
	public void altaCliente(long dniCliente, String nombre, String domicilio, String telefono, String mail){
		Cliente clienteTmp=new Cliente(dniCliente, nombre, domicilio, telefono, mail);
		clientes.add(clienteTmp);
	}
	
	public void bajaCliente(long dniCliente){
		Cliente clienteTmp=this.buscarCliente(dniCliente);
		if (clienteTmp!=null){
			clienteTmp.setActivo(false);
			clienteTmp.eliminarCliente();
			}
	}
	
	public void modificarCliente(long dniCliente, String nombre, String domicilio, String telefono, String mail){
		Cliente clienteTmp=this.buscarCliente(dniCliente);
		if (clienteTmp!=null){
			if (!clienteTmp.getNombre().equals(nombre) || 
				!clienteTmp.getDomicilio().equals(domicilio) ||
				!clienteTmp.getTelefono().equals(telefono) ||
				!clienteTmp.getMail().equals(mail)){
				clienteTmp.setNombre(nombre);
				clienteTmp.setDomicilio(domicilio);
				clienteTmp.setTelefono(telefono);
				clienteTmp.setMail(mail);
				clienteTmp.actualizarDatos();
			}
		}
	}
	
	public Vector<ClienteView> listarClientes(){
		Vector<Cliente> clientesTmp=Cliente.recuperarClientes();
		Vector<ClienteView> clientesViewTmp=new Vector<ClienteView>();
		if (clientesTmp!=null){
			for(int i=0;i<clientesTmp.size();i++){
				ClienteView cliViewTmp=clientesTmp.get(i).crearViewCliente();
				clientesViewTmp.add(cliViewTmp);
			}
		}
		return clientesViewTmp;
	}
	
	private Cliente buscarCliente(long dniCliente){
		Cliente clienteTmp = null;
		for (int i=0; i<clientes.size();i++){
			if (clientes.get(i).soyCliente(dniCliente)){
				clienteTmp=clientes.get(i);
				break;
			}
		}
		if (clienteTmp == null){
			clienteTmp = Cliente.recuperarCliente(dniCliente);
			if(clienteTmp != null)
				clientes.add(clienteTmp);
		}
		return clienteTmp;
	}
	
	/* Metodos para la administracion de los productos */
	
	public void altaProducto(long codigo, String titulo, String descripcion, float precio){
		Producto productoTmp=new Producto(codigo, titulo, descripcion, precio);
		productos.add(productoTmp);
	}
	
	private Producto buscarProducto(long codigo){
		Producto productoTmp = null;
		for (int i=0; i<productos.size();i++){
			if (productos.get(i).soyProducto(codigo)){
				productoTmp=productos.get(i);
				break;
			}
		}
		if (productoTmp == null){
			productoTmp = Producto.recuperarProducto(codigo);
			if(productoTmp != null)
				productos.add(productoTmp);
		}
		return productoTmp;
	}
	
	/* Metodos para la administracion de las facturas */
	
	private Factura buscarFactura(long nroFactura){
		Factura facturaTmp = null;
		for (int i=0; i<facturas.size();i++){
			if (facturas.get(i).soyFactura(nroFactura)){
				facturaTmp=facturas.get(i);
				break;
			}
		}
		if (facturaTmp == null){
			facturaTmp = Factura.recuperarFactura(nroFactura);
			if(facturaTmp != null)
				facturas.add(facturaTmp);
		}
		return facturaTmp;
	}
	
	/* Metodos para la administracion de los reclamos */
	
	public void altaReclamoZona(long dniCliente, String descripcion){
		Cliente clienteTmp = this.buscarCliente(dniCliente);
		ReclamoZona reclamoZonaTmp = new ReclamoZona(descripcion, clienteTmp);
		reclamos.add(reclamoZonaTmp);
	}
	
	public void altaReclamoCantidad(long dniCliente, String descripcion, Vector<ItemProductoReclamoView> itemProdRecView){
		Cliente clienteTmp = this.buscarCliente(dniCliente);
		Vector<ItemProductoReclamo> itemProdRecsTmp = new Vector<ItemProductoReclamo>();
		for(int i=0;i<itemProdRecView.size();i++){
			Producto productoTmp = this.buscarProducto(itemProdRecView.get(i).getProducto().getCodigo());
			ItemProductoReclamo itemProdRecTmp = new ItemProductoReclamo(productoTmp, itemProdRecView.get(i).getCantidad());
			itemProdRecsTmp.add(itemProdRecTmp);
		}
		ReclamoCantidad reclamoCantidadTmp = new ReclamoCantidad(descripcion, clienteTmp, itemProdRecsTmp);
		reclamos.add(reclamoCantidadTmp);
	}
	
	public void altaReclamoFaltante(long dniCliente, String descripcion, Vector<ItemProductoReclamoView> itemProdRecView){
		ReclamoFaltante reclamoFaltanteTmp = this.altaRecFalInt(dniCliente, descripcion, itemProdRecView); 
		reclamos.add(reclamoFaltanteTmp);
	}
	
	private ReclamoFaltante altaRecFalInt(long dniCliente, String descripcion, Vector<ItemProductoReclamoView> itemProdRecView){
		Cliente clienteTmp = this.buscarCliente(dniCliente);
		Vector<ItemProductoReclamo> itemProdRecsTmp = new Vector<ItemProductoReclamo>();
		for(int i=0;i<itemProdRecView.size();i++){
			Producto productoTmp = this.buscarProducto(itemProdRecView.get(i).getProducto().getCodigo());
			ItemProductoReclamo itemProdRecTmp = new ItemProductoReclamo(productoTmp, itemProdRecView.get(i).getCantidad());
			itemProdRecsTmp.add(itemProdRecTmp);
		}
		return new ReclamoFaltante(descripcion, clienteTmp, itemProdRecsTmp);
	}	
	
	
	public void altaReclamoFacturacion(long dniCliente, String descripcion, Vector<Long> nrosFactura){
		ReclamoFacturacion reclamoFacturacionTmp = this.altaRecFacInt(dniCliente, descripcion, nrosFactura);
		reclamos.add(reclamoFacturacionTmp);
	}
	
	private ReclamoFacturacion altaRecFacInt(long dniCliente, String descripcion, Vector<Long> nrosFactura){
		Cliente clienteTmp = this.buscarCliente(dniCliente);
		Vector<Factura> facturasTmp = new Vector<Factura>();
		for(int i=0;i<nrosFactura.size();i++){
			Factura facturaTmp = this.buscarFactura(nrosFactura.get(i));
			facturasTmp.add(facturaTmp);
		}
		return new ReclamoFacturacion(descripcion, clienteTmp, facturasTmp);
	}
	
	public void altaReclamoProducto(long dniCliente, String descripcion, Vector<ItemProductoReclamoView> itemProdRecView, Vector<Long> nrosFactura){
		Vector<Reclamo> reclamosTmp = new Vector<Reclamo>();
		ReclamoFacturacion reclamoFacturacionTmp = this.altaRecFacInt(dniCliente, descripcion, nrosFactura);
		ReclamoFaltante reclamoFaltanteTmp = this.altaRecFalInt(dniCliente, descripcion, itemProdRecView);
		reclamos.add(reclamoFacturacionTmp);
		reclamos.add(reclamoFaltanteTmp);
		reclamosTmp.add(reclamoFacturacionTmp);
		reclamosTmp.add(reclamoFaltanteTmp);
		ReclamoProducto reclamoProductoTmp = new ReclamoProducto(reclamosTmp);
		reclamos.add(reclamoProductoTmp);		
	}
}
