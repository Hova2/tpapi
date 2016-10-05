package ar.edu.uade.tpapi.vista;

import ar.edu.uade.tpapi.controlador.Controlador;

public class ReclamoZonaAlta {

	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		c.altaReclamoZona(1, "Reclamo zona nro:1");
		c.altaReclamoZona(5, "Reclamo zona nro:2");
	}
}
