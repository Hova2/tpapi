package ar.edu.uade.tpapi.vista;

import java.util.Vector;

import ar.edu.uade.tpapi.controlador.Controlador;

public class ModificaCliente {

	public static void main(String[] args) {
		Controlador c = Controlador.getInstance();
		Vector<ClienteView> clientesViewTmp=null;
		clientesViewTmp = c.listarClientes();
		for(int i=0;i<clientesViewTmp.size();i++){
			System.out.println(clientesViewTmp.get(i).getDniCliente());
			System.out.println(clientesViewTmp.get(i).getNombre());
			System.out.println(clientesViewTmp.get(i).getDomicilio());
			System.out.println(clientesViewTmp.get(i).getTelefono());
			System.out.println(clientesViewTmp.get(i).getMail());
			System.out.println(clientesViewTmp.get(i).isActivo());
		}
		c.modificarCliente(10, "Juan", "Juan1", "Juan2", "Juani");
		c.modificarCliente(5, "Juan3", "Juan23", "Juan233", "Juani2");
		clientesViewTmp = c.listarClientes();
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
