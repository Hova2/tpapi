package ar.edu.uade.tpapi.modelo;

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

}
