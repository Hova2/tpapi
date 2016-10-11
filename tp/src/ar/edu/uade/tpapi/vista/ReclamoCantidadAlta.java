package ar.edu.uade.tpapi.vista;

import java.util.Vector;

import ar.edu.uade.tpapi.controlador.Controlador;

public class ReclamoCantidadAlta {

	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		Vector<ItemProductoReclamoView> itemProdRecViewsTmp = new Vector<ItemProductoReclamoView>();
		for (int i=1;i<=10;i++){
			ProductoView productoViewTmp = new ProductoView(i,"Producto"+Integer.toString(i),"Es el producto:"+Integer.toString(i),i,true); 
			ItemProductoReclamoView itemProdRecViewTmp = new ItemProductoReclamoView(productoViewTmp, i);
			itemProdRecViewsTmp.add(itemProdRecViewTmp);
		}
		
		c.altaReclamoCantidad(2, "Reclamo cantidad nro:1",itemProdRecViewsTmp);
		c.altaReclamoCantidad(4, "Reclamo cantidad nro:2",itemProdRecViewsTmp);

	}

}
