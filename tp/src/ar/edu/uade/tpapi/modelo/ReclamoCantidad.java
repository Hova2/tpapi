package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoCantidadPersistencia;

public class ReclamoCantidad extends Reclamo {

	private Vector<ItemProducto> productos;

	public ReclamoCantidad(long dniCliente, String descripcion, int estado, Vector<ItemProducto> productos) {
		super(dniCliente, descripcion, estado);
		this.productos = productos;
		ReclamoCantidadPersistencia.getInstance().insert(this);
	}

	public ReclamoCantidad(long nroReclamo, Date fechaAlta, Date fechaCierre,
			long dniCliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<ItemProducto> productos) {
		super(nroReclamo, fechaAlta, fechaCierre, dniCliente, descripcion, estado,
				acciones);
		this.productos = productos;
	}
}