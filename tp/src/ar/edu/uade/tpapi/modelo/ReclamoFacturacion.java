package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public class ReclamoFacturacion extends Reclamo {

	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private Cliente cliente;
	private Vector<Factura> facturas;
	private Vector<Accion> acciones;

	public ReclamoFacturacion(String descripcion, Cliente cliente, Vector<Factura> facturas) {
		super();
		this.fechaAlta = new Date();
		this.fechaCierre = null;
		this.descripcion = descripcion;
		this.estado = 1;
		this.cliente = cliente;
		this.facturas = facturas;
		this.acciones = new Vector<Accion>();
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoFacturacion(long nroReclamo, Date fechaAlta,
			Date fechaCierre, Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<Factura> facturas) {
		super(nroReclamo);
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.cliente = cliente;
		this.facturas = facturas;
		this.acciones = acciones;
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

	public Cliente getCliente() {
		return cliente;
	}

	public Vector<Factura> getFacturas() {
		return facturas;
	}
}
