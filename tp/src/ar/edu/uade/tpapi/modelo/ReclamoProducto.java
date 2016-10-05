package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoProductoPersistencia;

public class ReclamoProducto extends Reclamo {

	private Vector<Reclamo> reclamos;

	public ReclamoProducto(long dniCliente, int estado, Vector<Reclamo> reclamos) {
		super(dniCliente, "Reclamo compuesto" , estado);
		this.reclamos = reclamos;
		ReclamoProductoPersistencia.getInstance().insert(this);
	}

	public ReclamoProducto(long nroReclamo, Date fechaAlta, Date fechaCierre,
			long dniCliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<Reclamo> reclamos) {
		super(nroReclamo, fechaAlta, fechaCierre, dniCliente, descripcion, estado,
				acciones);
		this.reclamos = reclamos;
	}
}
