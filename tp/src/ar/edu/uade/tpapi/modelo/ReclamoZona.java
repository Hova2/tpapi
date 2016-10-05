package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoZonaPersistencia;

public class ReclamoZona extends Reclamo {
	
	public ReclamoZona(long dniCliente, String descripcion, int estado) {
		super(dniCliente, descripcion, estado);
		ReclamoZonaPersistencia.getInstance().insert(this);
	}

	public ReclamoZona(long nroReclamo, Date fechaAlta, Date fechaCierre,
			long dniCliente, String descripcion, int estado,
			Vector<Accion> acciones) {
		super(nroReclamo, fechaAlta, fechaCierre, dniCliente, descripcion, estado,
				acciones);
	}

}
