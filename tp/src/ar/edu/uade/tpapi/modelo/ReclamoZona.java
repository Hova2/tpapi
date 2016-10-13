package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.ReclamoZonaView;

public class ReclamoZona extends Reclamo {
	
	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private Cliente cliente;
	private Vector<Accion> acciones;
	
	public ReclamoZona(String descripcion, Cliente cliente) {
		super();
		this.fechaAlta = new Date();
		this.fechaCierre = null;
		this.descripcion = descripcion;
		this.estado = 1;
		this.tipoReclamo = 0;
		this.cliente = cliente;
		this.acciones = new Vector<Accion>();
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoZona(long nroReclamo, Date fechaAlta, Date fechaCierre,
			String descripcion, int estado, int tipoReclamo, Vector<Accion> acciones, Cliente cliente) {
		super(nroReclamo);
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
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
		ReclamoPersistencia.getInstance().cambiarEstado(estado, super.getNroReclamo());
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

	public int getTipoReclamo() {
		return tipoReclamo;
	}
	
	public void agregarAccion(String detalle){
		Accion accionTmp = new Accion(detalle);
		acciones.add(accionTmp);
		ReclamoPersistencia.getInstance().insertarAccion(accionTmp, super.getNroReclamo());
	}
	
	public ReclamoZonaView crearReclamoZonaView(){
		ClienteView clienteViewTmp = this.cliente.crearViewCliente();
		Vector<AccionView> accionesViewTmp = new Vector<AccionView>();
		for(int i = 0; i<this.acciones.size(); i++){
			AccionView accionViewTmp = this.acciones.get(i).crearViewAccion();
			accionesViewTmp.add(accionViewTmp);
		}
		ReclamoZonaView reclamoZonaViewTmp = new ReclamoZonaView(super.getNroReclamo(), this.fechaAlta, this.fechaCierre, this.descripcion, 
				this.estado, this.tipoReclamo, clienteViewTmp, accionesViewTmp);
		return reclamoZonaViewTmp;
	} 
}
