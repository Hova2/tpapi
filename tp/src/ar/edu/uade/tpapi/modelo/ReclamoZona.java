package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public class ReclamoZona extends Reclamo {
	
	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private Cliente cliente;
	private Vector<Accion> acciones;
	
	public ReclamoZona(String descripcion, Cliente cliente) {
		super();
		this.fechaAlta = new Date();
		this.fechaCierre = null;
		this.descripcion = descripcion;
		this.estado = 1;
		this.cliente = cliente;
		this.acciones = new Vector<Accion>();
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoZona(long nroReclamo, Date fechaAlta, Date fechaCierre,
			String descripcion, int estado, Vector<Accion> acciones, Cliente cliente) {
		super(nroReclamo);
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.acciones = acciones;
		this.cliente = cliente;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
}
