package ar.edu.uade.tpapi.controlador;

import java.util.Vector;
import ar.edu.uade.tpapi.modelo.Cliente;

public class Controlador {

	private static Controlador instancia;
	private Vector <Cliente> clientes;
	
	private Controlador() {
		clientes = new Vector<Cliente>();
	}
	
	public static Controlador getInstance(){
		return (instancia!=null) ? instancia : new Controlador();
	}
	
	public void altaCliente(String nombre, String domicilio, String telefono, String mail){
		this.clientes.add(new Cliente(nombre,domicilio,telefono,mail,true));
	}
}
