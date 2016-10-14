package ar.edu.uade.tpapi.modelo;

import ar.edu.uade.tpapi.vista.ItemProductoReclamoView;
import ar.edu.uade.tpapi.vista.ProductoView;

public class ItemProductoReclamo {

	private Producto producto;
	private int cantidad;
	
	public ItemProductoReclamo(Producto producto, int cantidad) {
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
	
	public ItemProductoReclamoView crearViewItemProductoReclamo(){
		ProductoView productoViewTmp = producto.crearViewProducto();
		ItemProductoReclamoView itemProductoReclamoViewTmp = new ItemProductoReclamoView(productoViewTmp, this.cantidad);
		return itemProductoReclamoViewTmp;
	}

}
