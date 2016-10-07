package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoCantidadPersistencia;

public class ReclamoCantidad extends Reclamo {

	private Vector<ItemProducto> productos;

	public ReclamoCantidad(Cliente cliente, String descripcion, int estado, Vector<ItemProducto> productos) {
		super(cliente, descripcion, estado);
		this.productos = productos;
		ReclamoCantidadPersistencia.getInstance().insert(this);
	}

	public ReclamoCantidad(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<ItemProducto> productos) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
		this.productos = productos;
	}
}