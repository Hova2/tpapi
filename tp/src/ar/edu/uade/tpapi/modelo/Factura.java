package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.FacturaPersistencia;

public class Factura {

	private long nroFactura;
	private Date fecha;
	private float total;
	private Cliente cliente;
	private Vector<ItemFactura> itemsFactura;
	
	public Factura(long nroFactura, Date fecha, float total, Cliente cliente,
			Vector<ItemFactura> itemsFactura) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.itemsFactura = itemsFactura;
	}

	public long getNroFactura() {
		return nroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public float getTotal() {
		return total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vector<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}
	
	public boolean soyFactura(long nroFactura){
		return this.nroFactura == nroFactura;
	}
	
	public static Factura recuperarFactura(long nroFactura){
		return FacturaPersistencia.getInstance().recuperarFactura(nroFactura);
	}
}
