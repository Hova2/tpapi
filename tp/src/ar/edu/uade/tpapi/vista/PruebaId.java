package ar.edu.uade.tpapi.vista;

import ar.edu.uade.tpapi.persistencia.ClientePersistencia;



public class PruebaId {
	
	public static void main(String[] args) {
		System.out.print(ClientePersistencia.getInstance().getLastId());
	}

}
