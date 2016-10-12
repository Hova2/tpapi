package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

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
}
