package ar.edu.uade.tpapi.modelo;

import ar.edu.uade.tpapi.vista.ItemFacturaView;
import ar.edu.uade.tpapi.vista.ProductoView;

public class ItemFactura {

	private Producto producto;
	private int cantidad;
	
	public ItemFactura(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public ItemFacturaView crearItemFacturaView(){
		ProductoView productoViewTmp = producto.crearViewProducto();
		ItemFacturaView itemFacturaViewTmp = new ItemFacturaView(productoViewTmp, this.cantidad);
		return itemFacturaViewTmp;
	}
}
