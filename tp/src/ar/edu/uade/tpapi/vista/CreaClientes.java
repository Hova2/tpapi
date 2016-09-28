package ar.edu.uade.tpapi.vista;

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
		c.listarClientes();
	}

}
