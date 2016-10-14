package ar.edu.uade.tpapi.modelo;

import java.util.Date;
import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.FacturaPersistencia;
import ar.edu.uade.tpapi.vista.AccionView;
import ar.edu.uade.tpapi.vista.ClienteView;
import ar.edu.uade.tpapi.vista.FacturaView;
import ar.edu.uade.tpapi.vista.ItemFacturaView;

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
	
	public FacturaView crearFacturaView(){
		ClienteView clienteViewTmp = this.cliente.crearViewCliente();
		Vector<ItemFacturaView> itemsFacturaViewTmp = new Vector<ItemFacturaView>();
		for(int i = 0; i<itemsFactura.size();i++){
			ItemFacturaView itemFacturaViewTmp = itemsFactura.get(i).crearItemFacturaView();
			itemsFacturaViewTmp.add(itemFacturaViewTmp);
		}
		FacturaView facturaViewTmp = new FacturaView(this.nroFactura, this.fecha, this.total, clienteViewTmp, itemsFacturaViewTmp);
		return facturaViewTmp;
	}
	
	public static Factura recuperarFactura(long nroFactura){
		return FacturaPersistencia.getInstance().recuperarFactura(nroFactura);
	} 
}
