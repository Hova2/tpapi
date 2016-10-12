package ar.edu.uade.tpapi.vista;

import java.util.Date;

public class AccionView {
	
	private long nroAccion;
	private Date fechaAlta;
	private String detalle;
	
	public AccionView(long nroAccion, Date fechaAlta, String detalle) {
		super();
		this.nroAccion = nroAccion;
		this.fechaAlta = fechaAlta;
		this.detalle = detalle;
	}

	public long getNroAccion() {
		return nroAccion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public String getDetalle() {
		return detalle;
	}
	
}
