package ar.edu.uade.tpapi.vista;

import java.util.Vector;

import ar.edu.uade.tpapi.controlador.Controlador;

public class CreaClientes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		for (int i=1;i<=10;i++){
			c.altaCliente(i,"Cliente"+Integer.toString(i),"DomCliente"+Integer.toString(i)
					,Integer.toString(i),"cliente"+Integer.toString(i)+"@clientes.com");
		}
		Vector<ClienteView> clientesViewTmp = c.listarClientes();
		for(int i=0;i<clientesViewTmp.size();i++){
			System.out.println(clientesViewTmp.get(i).getDniCliente());
			System.out.println(clientesViewTmp.get(i).getNombre());
			System.out.println(clientesViewTmp.get(i).getDomicilio());
			System.out.println(clientesViewTmp.get(i).getTelefono());
			System.out.println(clientesViewTmp.get(i).getMail());
			System.out.println(clientesViewTmp.get(i).isActivo());
		}
	}
}
