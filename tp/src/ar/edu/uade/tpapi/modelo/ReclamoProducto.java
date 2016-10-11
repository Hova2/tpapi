package ar.edu.uade.tpapi.modelo;

import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public class ReclamoProducto extends Reclamo {

	private Vector<Reclamo> reclamos;

	public ReclamoProducto(Vector<Reclamo> reclamos) {
		super();
		this.reclamos = reclamos;
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoProducto(long nroReclamo, Vector<Reclamo> reclamos) {
		super(nroReclamo);
		this.reclamos = reclamos;
	}

	public Vector<Reclamo> getReclamos() {
		return reclamos;
	}
}
