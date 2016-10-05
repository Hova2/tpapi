package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoProductoPersistencia;

public class ReclamoProducto extends Reclamo {

	private Vector<Reclamo> reclamos;

	public ReclamoProducto(Cliente cliente, int estado, Vector<Reclamo> reclamos) {
		super(cliente, "Reclamo compuesto" , estado);
		this.reclamos = reclamos;
		ReclamoProductoPersistencia.getInstance().insert(this);
	}

	public ReclamoProducto(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<Reclamo> reclamos) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
		this.reclamos = reclamos;
	}
}
