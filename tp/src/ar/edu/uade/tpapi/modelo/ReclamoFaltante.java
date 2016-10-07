package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoFaltantePersistencia;

public class ReclamoFaltante extends Reclamo {

	private Vector<ItemProducto> productos;

	public ReclamoFaltante(Cliente cliente, String descripcion, int estado, Vector<ItemProducto> productos) {
		super(cliente, descripcion, estado);
		this.productos = productos;
		ReclamoFaltantePersistencia.getInstance().insert(this);
	}

	public ReclamoFaltante(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<ItemProducto> productos) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
		this.productos = productos;
	}
}
