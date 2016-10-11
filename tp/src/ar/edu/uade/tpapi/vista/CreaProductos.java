package ar.edu.uade.tpapi.vista;

import ar.edu.uade.tpapi.controlador.Controlador;

public class CreaProductos {

	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		for (int i=1;i<=10;i++){
			c.altaProducto(i,"Producto"+Integer.toString(i),"Es el producto:"+Integer.toString(i)
					,i);
		}
		/*Vector<ClienteView> clientesViewTmp = c.listarClientes();
		for(int i=0;i<clientesViewTmp.size();i++){
			System.out.println(clientesViewTmp.get(i).getDniCliente());
			System.out.println(clientesViewTmp.get(i).getNombre());
			System.out.println(clientesViewTmp.get(i).getDomicilio());
			System.out.println(clientesViewTmp.get(i).getTelefono());
			System.out.println(clientesViewTmp.get(i).getMail());
			System.out.println(clientesViewTmp.get(i).isActivo());
		}*/

	}

}
