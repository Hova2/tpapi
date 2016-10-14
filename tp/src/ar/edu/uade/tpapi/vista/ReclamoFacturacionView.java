package ar.edu.uade.tpapi.vista;

import java.util.Date;
import java.util.Vector;

public class ReclamoFacturacionView {

	private long nroReclamo;
	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private ClienteView cliente;
	private Vector<FacturaView> facturas;
	private Vector<AccionView> acciones;
	
	public ReclamoFacturacionView(long nroReclamo, Date fechaAlta, Date fechaCierre,
			String descripcion, int estado, int tipoReclamo,
			ClienteView cliente, Vector<FacturaView> facturas,
			Vector<AccionView> acciones) {
		super();
		this.nroReclamo = nroReclamo;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
		this.cliente = cliente;
		this.facturas = facturas;
		this.acciones = acciones;
	}

	public long getNroReclamo(){
		return nroReclamo;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public int getTipoReclamo() {
		return tipoReclamo;
	}

	public ClienteView getCliente() {
		return cliente;
	}

	public Vector<FacturaView> getFacturas() {
		return facturas;
	}

	public Vector<AccionView> getAcciones() {
		return acciones;
	}
}
