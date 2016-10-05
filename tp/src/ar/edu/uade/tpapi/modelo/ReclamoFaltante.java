package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoFaltantePersistencia;

public class ReclamoFaltante extends Reclamo {

	private Vector<ItemProducto> productos;

	public ReclamoFaltante(long dniCliente, String descripcion, int estado, Vector<ItemProducto> productos) {
		super(dniCliente, descripcion, estado);
		this.productos = productos;
		ReclamoFaltantePersistencia.getInstance().insert(this);
	}

	public ReclamoFaltante(long nroReclamo, Date fechaAlta, Date fechaCierre,
			long dniCliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<ItemProducto> productos) {
		super(nroReclamo, fechaAlta, fechaCierre, dniCliente, descripcion, estado,
				acciones);
		this.productos = productos;
	}
}
