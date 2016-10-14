package ar.edu.uade.tpapi.vista;

import java.util.Date;
import java.util.Vector;

public class ReclamoFaltanteView {

	private long nroReclamo;
	private Date fechaAlta;
	private Date fechaCierre;
	private ClienteView cliente;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private Vector<ItemProductoReclamoView> productos;
	private Vector<AccionView> acciones;
	
	public ReclamoFaltanteView(long nroReclamo, Date fechaAlta,
			Date fechaCierre, ClienteView cliente, String descripcion,
			int estado, int tipoReclamo,
			Vector<ItemProductoReclamoView> productos,
			Vector<AccionView> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
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

	public ClienteView getCliente() {
		return cliente;
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

	public Vector<ItemProductoReclamoView> getProductos() {
		return productos;
	}

	public Vector<AccionView> getAcciones() {
		return acciones;
	}
}
