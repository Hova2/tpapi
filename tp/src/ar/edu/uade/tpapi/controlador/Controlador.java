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
		Cliente clienteTmp=new Cliente(nombre, domicilio, telefono, mail); 
		if (clienteTmp.getIdCliente()!=-1)
			this.clientes.add(clienteTmp);
		else
			System.out.println("Error al cargar el cliente");  
	}
	
	public void listarClientes(){
		for(int i=0; i<this.clientes.size(); i++){
			System.out.println(this.clientes.get(i).getIdCliente());
			System.out.println(this.clientes.get(i).getNombre());
			System.out.println(this.clientes.get(i).getDomicilio());
			System.out.println(this.clientes.get(i).getTelefono());
			System.out.println(this.clientes.get(i).getMail());
			if (this.clientes.get(i).isActivo())
				System.out.println("Usuario activo");
			else
				System.out.println("Usuario no activo");
				
				
		}
	}
}
