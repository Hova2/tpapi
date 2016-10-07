package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoZonaPersistencia;

public class ReclamoZona extends Reclamo {
	
	public ReclamoZona(Cliente cliente, String descripcion, int estado) {
		super(cliente, descripcion, estado);
		ReclamoZonaPersistencia.getInstance().insert(this);
	}

	public ReclamoZona(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
	}

}
