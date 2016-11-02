package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.ItemProductoReclamoView;

public class ReclamoProducto extends Reclamo {

	private long nroReclamo;
	private ItemProductoReclamoView producto;
	private Date fechaAlta;
	private Date fechaCierre;
	private ClienteView cliente;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private Vector<Reclamo> reclamos;
	private Vector<AccionView> acciones;

	public ReclamoProducto(long nroReclamo, ItemProductoReclamoView producto, Date fechaAlta, Date fechaCierre,
			ClienteView cliente, String descripcion, int estado, int tipoReclamo, Vector<Reclamo> reclamos, 
			Vector<AccionView> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.producto = producto;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
		this.reclamos = reclamos;
		this.acciones = acciones;
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoProducto(Vector<Reclamo> reclamos) {
		super();
		this.reclamos = reclamos;
	}

	public Vector<Reclamo> getReclamos() {
		return reclamos;
	}

	@Override
	public Vector<String> toVector() {
		// TODO Auto-generated method stub
		return null;
	}
}
