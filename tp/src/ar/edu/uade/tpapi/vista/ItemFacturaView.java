package ar.edu.uade.tpapi.vista;

public class ItemFacturaView {
	
	private ProductoView producto;
	private int cantidad;
	
	public ItemFacturaView(ProductoView producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public ProductoView getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
}
