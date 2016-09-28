package ar.edu.uade.tpapi.controlador;

import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;
import ar.edu.uade.tpapi.persistencia.ClientePersistencia;

public class Controlador {

	private static Controlador instancia;
	private Vector <Cliente> clientes;
	
	private Controlador() {
		clientes = new Vector<Cliente>();
	}
	
	public static Controlador getInstance(){
		return (instancia!=null) ? instancia : new Controlador();
	}
	
	public void altaCliente(long dniCliente, String nombre, String domicilio, String telefono, String mail){
		Cliente clienteTmp=new Cliente(dniCliente, nombre, domicilio, telefono, mail);
		clientes.add(clienteTmp);
	}
	
	public void bajaCliente(long dniCliente){
		Cliente clienteTmp=this.buscarCliente(dniCliente);
		if (clienteTmp!=null)
			clienteTmp.eliminarAfiliado();
	}
	
	public void listarClientes(){
		for(int i=0; i<this.clientes.size(); i++){
			System.out.println(this.clientes.get(i).getDniCliente());
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
	
	private Cliente buscarCliente(long dniCliente){
		Cliente clienteTmp=null;
		for (int i=0; i<clientes.size();i++){
			if (clientes.get(i).getDniCliente()==dniCliente){
				clienteTmp=clientes.get(i);
				break;
			}
		}
		if (clienteTmp==null)
			clienteTmp=ClientePersistencia.getInstance().buscarCliente(dniCliente);
		return clienteTmp;
	}
}
