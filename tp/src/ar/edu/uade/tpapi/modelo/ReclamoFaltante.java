package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.ItemProductoReclamoView;
import ar.edu.uade.tpapi.vista.ProductoView;
import ar.edu.uade.tpapi.vista.ReclamoCantidadView;
import ar.edu.uade.tpapi.vista.ReclamoFaltanteView;

public class ReclamoFaltante extends Reclamo {

	private Date fechaAlta;
	private Date fechaCierre;
	private Cliente cliente;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private Vector<ItemProductoReclamo> productos;
	private Vector<Accion> acciones;

	public ReclamoFaltante(String descripcion, Cliente cliente, Vector<ItemProductoReclamo> productos) {
		super();
		this.fechaAlta = new Date();
		this.fechaCierre = null;
		this.descripcion = descripcion;
		this.estado = 1;
		this.tipoReclamo = 2;
		this.cliente = cliente;
		this.productos = productos;
		this.acciones = new Vector<Accion>();
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoFaltante(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado, int tipoReclamo, 
			Vector<Accion> acciones, Vector<ItemProductoReclamo> productos) {
		super(nroReclamo);
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
		this.cliente = cliente;
		this.productos = productos;
		this.acciones = acciones;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
		ReclamoPersistencia.getInstance().cambiarEstado(estado, super.getNroReclamo());
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Vector<ItemProductoReclamo> getProductos() {
		return productos;
	}

	public int getTipoReclamo() {
		return tipoReclamo;
	}
	
	public void agregarAccion(String detalle){
		Accion accionTmp = new Accion(detalle);
		acciones.add(accionTmp);
		ReclamoPersistencia.getInstance().insertarAccion(accionTmp, super.getNroReclamo());
	}
	
	public ReclamoFaltanteView crearReclamoFaltanteView(){
		ClienteView clienteViewTmp = this.cliente.crearViewCliente();
		Vector<AccionView> accionesViewTmp = new Vector<AccionView>();
		for(int i = 0; i<this.acciones.size(); i++){
			AccionView accionViewTmp = this.acciones.get(i).crearViewAccion();
			accionesViewTmp.add(accionViewTmp);
		}
		Vector<ItemProductoReclamoView> productosViewTmp = new Vector<ItemProductoReclamoView>();
		for(int i = 0; i<this.productos.size(); i++){
			ItemProductoReclamoView itemProductoReclamoViewTmp = productos.get(i).crearViewItemProductoReclamo();
			productosViewTmp.add(itemProductoReclamoViewTmp);
		}
		ReclamoFaltanteView reclamoFaltanteViewTmp = new ReclamoFaltanteView(super.getNroReclamo(), this.fechaAlta, this.fechaCierre, clienteViewTmp, this.descripcion, 
				this.estado, this.tipoReclamo, productosViewTmp, accionesViewTmp); 
		return reclamoFaltanteViewTmp;
	}
}
