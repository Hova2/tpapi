package ar.edu.uade.tpapi.modelo;

import java.time.LocalDateTime;

import ar.edu.uade.tpapi.persistencia.AccionPersistencia;

public class Accion {

	private static long nroUltimaAccion=0;
	private long nroAccion;
	private LocalDateTime fechaAlta;
	private String detalle;
	
	public Accion(String detalle) {
		super();
		this.nroAccion=this.buscaNroUltimaAccion();
		nroUltimaAccion++;
		this.fechaAlta=LocalDateTime.now();
		this.detalle=detalle;
		AccionPersistencia.getInstance().insert(this);
	}
	
	public Accion(long nroAccion, LocalDateTime fechaAlta, String detalle) {
		super();
		this.nroAccion=nroAccion;
		this.fechaAlta=fechaAlta;
		this.detalle=detalle;
	}
			
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle=detalle;
	}

	public long getNroAccion() {
		return nroAccion;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	private long buscaNroUltimaAccion(){
		return (nroUltimaAccion!=0) ? nroUltimaAccion : AccionPersistencia.getInstance().ultimoNumero();
	}
}
