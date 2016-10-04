package ar.edu.uade.tpapi.modelo;

import java.time.LocalDateTime;
import java.util.Vector;

public abstract class Reclamo {

	private long nroReclamo;
	private LocalDateTime fechaAlta;
	private LocalDateTime fechaCierre;
	private Cliente cli;
	private String descripcion;
	private int estado;
	private Vector<Accion> acciones;
	
	public void agregarAccion(Accion acc){
		acciones.add(acc);
	}
	
}
