package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.FacturaView;
import ar.edu.uade.tpapi.vista.ItemProductoReclamoView;
import ar.edu.uade.tpapi.vista.ProductoView;
import ar.edu.uade.tpapi.vista.ReclamoCantidadView;
import ar.edu.uade.tpapi.vista.ReclamoFacturacionView;

public class ReclamoFacturacion extends Reclamo {

	private Date fechaAlta;
	private Date fechaCierre;
	private String descripcion;
	private int estado;
	private int tipoReclamo;
	private Cliente cliente;
	private Vector<Factura> facturas;
	private Vector<Accion> acciones;

	public ReclamoFacturacion(String descripcion, Cliente cliente, Vector<Factura> facturas) {
		super();
		this.fechaAlta = new Date();
		this.fechaCierre = null;
		this.descripcion = descripcion;
		this.estado = 1;
		this.tipoReclamo = 3;
		this.cliente = cliente;
		this.facturas = facturas;
		this.acciones = new Vector<Accion>();
		ReclamoPersistencia.getInstance().insert(this);
	}

	public ReclamoFacturacion(long nroReclamo, Date fechaAlta,
			Date fechaCierre, Cliente cliente, String descripcion, int estado, int tipoReclamo,
			Vector<Accion> acciones, Vector<Factura> facturas) {
		super(nroReclamo);
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoReclamo = tipoReclamo;
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
		ReclamoPersistencia.getInstance().cambiarEstado(estado, super.getNroReclamo());
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
	
	public int getTipoReclamo() {
		return tipoReclamo;
	}
	
	public void agregarAccion(String detalle){
		Accion accionTmp = new Accion(detalle);
		acciones.add(accionTmp);
		ReclamoPersistencia.getInstance().insertarAccion(accionTmp, super.getNroReclamo());
	}
	
	public ReclamoFacturacionView crearReclamoFacturacionView(){
		ClienteView clienteViewTmp = this.cliente.crearViewCliente();
		Vector<AccionView> accionesViewTmp = new Vector<AccionView>();
		for(int i = 0; i<this.acciones.size(); i++){
			AccionView accionViewTmp = this.acciones.get(i).crearViewAccion();
			accionesViewTmp.add(accionViewTmp);
		}
		Vector<FacturaView> facturasViewTmp = new Vector<FacturaView>();
		for(int i = 0; i<this.facturas.size(); i++){
			FacturaView facturaViewTmp = facturas.get(i).crearFacturaView();
			facturasViewTmp.add(facturaViewTmp);
		}
		ReclamoFacturacionView reclamoFacturacionViewTmp = new ReclamoFacturacionView(super.getNroReclamo(), this.fechaAlta, this.fechaCierre, this.descripcion, 
				this.estado, this.tipoReclamo, clienteViewTmp, facturasViewTmp, accionesViewTmp); 
		return reclamoFacturacionViewTmp;
	}

	@Override
	public Vector<String> toVector() {
		// TODO Auto-generated method stub
		return null;
	}
}
