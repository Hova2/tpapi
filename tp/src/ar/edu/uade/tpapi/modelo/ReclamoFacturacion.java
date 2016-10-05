package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoFacturacionPersistencia;

public class ReclamoFacturacion extends Reclamo {

	private Vector<Factura> facturas;

	public ReclamoFacturacion(Cliente cliente, String descripcion, int estado, Vector<Factura> facturas) {
		super(cliente, descripcion, estado);
		this.facturas = facturas;
		ReclamoFacturacionPersistencia.getInstance().insert(this);
	}

	public ReclamoFacturacion(long nroReclamo, Date fechaAlta,
			Date fechaCierre, Cliente cliente, String descripcion, int estado,
			Vector<Accion> acciones, Vector<Factura> facturas) {
		super(nroReclamo, fechaAlta, fechaCierre, cliente, descripcion, estado,
				acciones);
		this.facturas = facturas;
	}
}
