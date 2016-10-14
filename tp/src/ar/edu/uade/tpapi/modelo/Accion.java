package ar.edu.uade.tpapi.modelo;

import java.util.Date;

import ar.edu.uade.tpapi.vista.AccionView;

public class Accion {

	private Date fechaAlta;
	private String detalle;
	
	public Accion(String detalle) {
		super();
		this.fechaAlta=new Date();
		this.detalle=detalle;
	}
		
	public Accion(Date fechaAlta, String detalle) {
	super();
	this.fechaAlta=fechaAlta;
	this.detalle=detalle;
	}
			
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle=detalle;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public AccionView crearViewAccion(){
		AccionView accionViewTmp = new AccionView(fechaAlta, detalle);
		return accionViewTmp;
	}
}
