package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public abstract class Reclamo {

	private static long nroUltimoReclamo=-1;
	private long nroReclamo;
	private Date fechaAlta;
	private Date fechaCierre;
	private Cliente cliente;
	private String descripcion;
	private int estado;
	private Vector<Accion> acciones;
	
	public Reclamo(Cliente cliente, String descripcion, int estado) {
		super();
		this.nroReclamo = this.buscaNroUltimoReclamo();
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaAlta = new Date();
	}
	
	public Reclamo(long nroReclamo, Date fechaAlta, Date fechaCierre,
			Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.cliente = cliente;
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
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setDniCliente(Cliente cliente) {
		this.cliente = cliente;
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
		if (nroUltimoReclamo==-1){
			nroUltimoReclamo=ReclamoPersistencia.getInstance().ultimoNumero();
		}
		return ++nroUltimoReclamo;
	}
	
}
