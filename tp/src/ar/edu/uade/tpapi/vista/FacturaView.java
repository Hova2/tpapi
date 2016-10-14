package ar.edu.uade.tpapi.vista;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;

public class FacturaView {

	private long nroFactura;
	private Date fecha;
	private float total;
	private ClienteView cliente;
	private Vector<ItemFacturaView> itemsFacturaView;
	
	public FacturaView(long nroFactura, Date fecha, float total, ClienteView cliente,
			Vector<ItemFacturaView> itemsFacturaView) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.itemsFacturaView = itemsFacturaView;
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

	public ClienteView getCliente() {
		return cliente;
	}

	public Vector<ItemFacturaView> getItemsFacturaView() {
		return itemsFacturaView;
	}	
}
