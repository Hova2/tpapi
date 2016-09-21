package ar.edu.uade.tpapi.vista;

import ar.edu.uade.tpapi.controlador.Controlador;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		c.altaCliente("Pepe3", "Pepe3", "Pepe3", "Pepe3");
		c.listarClientes();
	}

}
