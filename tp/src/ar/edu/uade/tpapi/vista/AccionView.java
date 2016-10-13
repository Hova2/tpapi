package ar.edu.uade.tpapi.vista;

import java.util.Date;

public class AccionView {
	
	private Date fechaAlta;
	private String detalle;
	
	public AccionView(Date fechaAlta, String detalle) {
		super();
		this.fechaAlta = fechaAlta;
		this.detalle = detalle;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public String getDetalle() {
		return detalle;
	}
	
}
