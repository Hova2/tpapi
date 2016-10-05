package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public abstract class Reclamo {

	private static long nroUltimoReclamo=0;
	private long nroReclamo;
	private Date fechaAlta;
	private Date fechaCierre;
	private long dniCliente;
	private String descripcion;
	private int estado;
	private Vector<Accion> acciones;
	
	public Reclamo(long dniCliente, String descripcion, int estado) {
		super();
		this.nroReclamo = this.buscaNroUltimoReclamo();
		this.dniCliente = dniCliente;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaAlta = new Date();
	}
	
	public Reclamo(long nroReclamo, Date fechaAlta, Date fechaCierre,
			long dniCliente, String descripcion, int estado,
			Vector<Accion> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.dniCliente = dniCliente;
		this.descripcion = descripcion;
		this.estado = estado;
		this.acciones = acciones;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
		
	public long getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(long dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public long getNroReclamo() {
		return nroReclamo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Vector<Accion> getAcciones() {
		return acciones;
	}

	public void agregarAccion(Accion acc){
		acciones.add(acc);
	}
	
	private long buscaNroUltimoReclamo(){
		if (nroUltimoReclamo==0){
			nroUltimoReclamo=ReclamoPersistencia.getInstance().ultimoNumero();
		}
		return ++nroUltimoReclamo;
	}
	
}
