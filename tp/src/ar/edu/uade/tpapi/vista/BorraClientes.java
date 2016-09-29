package ar.edu.uade.tpapi.vista;

import ar.edu.uade.tpapi.controlador.Controlador;

public class BorraClientes {

	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		for (int i=1;i<=10;i++){
			c.bajaCliente(i);
		}
		c.listarClientes();
	}
}
