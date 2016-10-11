package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoFaltantePersistencia;

public class ReclamoFaltante extends Reclamo {

	private Date fechaAlta;
	private Date fechaCierre;
	private Cliente cliente;
	private String descripcion;
	private int estado;
	private Vector<Accion> acciones;
	private Vector<ItemProductoReclamo> productos;

	public ReclamoFaltante(Cliente cliente, String descripcion, int estado, Vector<ItemProductoReclamo> productos) {
		super(cliente, descripcion, estado);
		this.productos = productos;
		ReclamoFaltantePersistencia.getInstance().insert(this);
	}

	public ReclamoFaltante(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<ItemProductoReclamo> productos) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
		this.productos = productos;
	}
}
