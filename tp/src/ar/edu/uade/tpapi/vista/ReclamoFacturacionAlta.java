package ar.edu.uade.tpapi.vista;

import java.util.Vector;

import ar.edu.uade.tpapi.controlador.Controlador;

public class ReclamoFacturacionAlta {

		public static void main(String[] args) {
			Controlador c = Controlador.getInstance();
			Vector<Long> facturasTmp = new Vector<Long>();
			long nro1Tmp = 5;
			long nro2Tmp = 6;
			facturasTmp.add(nro1Tmp);
			facturasTmp.add(nro2Tmp);
			c.altaReclamoFacturacion(1, "Reclamo facturacion nro:1", facturasTmp);
			

		}

	}
