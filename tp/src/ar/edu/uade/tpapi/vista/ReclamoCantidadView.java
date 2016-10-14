package ar.edu.uade.tpapi.vista;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Accion;

public class ReclamoCantidadView {

	private long nroReclamo;
	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private ClienteView cliente;
	private Vector<ItemProductoReclamoView> productos;
	private Vector<AccionView> acciones;
	
	public ReclamoCantidadView(long nroReclamo, Date fechaAlta,
			Date fechaCierre, String descripcion, int estado, int tipoReclamo,
			ClienteView cliente, Vector<ItemProductoReclamoView> productos,
			Vector<AccionView> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
		this.cliente = cliente;
		this.productos = productos;
		this.acciones = acciones;
	}
	
	public long getNroReclamo() {
		return nroReclamo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public int getTipoReclamo() {
		return tipoReclamo;
	}
	public ClienteView getCliente() {
		return cliente;
	}
	public Vector<ItemProductoReclamoView> getProductos() {
		return productos;
	}
	public Vector<Accion> getAcciones() {
		return acciones;
	}	
}
