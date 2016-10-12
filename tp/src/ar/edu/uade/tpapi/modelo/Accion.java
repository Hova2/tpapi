package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.AccionPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;

public class Accion {

	private static long nroUltimaAccion=0;
	private long nroAccion;
	private Date fechaAlta;
	private String detalle;
	
	public Accion(String detalle) {
		super();
		this.nroAccion=this.buscaNroUltimaAccion();
		nroUltimaAccion++;
		this.fechaAlta=new Date();
		this.detalle=detalle;
		AccionPersistencia.getInstance().insert(this);
	}
	
	public Accion(long nroAccion, Date fechaAlta, String detalle) {
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

	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public static Vector<Accion> recuperarAcciones(long nroReclamo){
		Vector<Accion> accionesTmp = AccionPersistencia.getInstance().recuperarAccionesReclamo(nroReclamo);
		return accionesTmp;
	}
	
	public AccionView crearViewAccion(){
		AccionView accionViewTmp = new AccionView(nroAccion, fechaAlta, detalle);
		return accionViewTmp;
	}

	private long buscaNroUltimaAccion(){
		return (nroUltimaAccion!=0) ? nroUltimaAccion : AccionPersistencia.getInstance().ultimoNumero();
	}
}
