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
		if (clienteTmp!=null){
			clienteTmp.setActivo(false);
			clienteTmp.eliminarCliente();
			}
	}
	
	public void listarClientes(){
		Vector<Cliente> clientesTmp=ClientePersistencia.getInstance().selectAll();
		if (clientesTmp!=null){
			for(int i=0;i<clientesTmp.size();i++){
				System.out.println(clientesTmp.get(i).getDniCliente());
				System.out.println(clientesTmp.get(i).getNombre());
				System.out.println(clientesTmp.get(i).getDomicilio());
				System.out.println(clientesTmp.get(i).getTelefono());
				System.out.println(clientesTmp.get(i).getMail());
				System.out.println(clientesTmp.get(i).isActivo());
			}
		}
		else{
			System.out.println("No existen clientes");
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
		if (clienteTmp==null){
			clienteTmp=ClientePersistencia.getInstance().buscarCliente(dniCliente);
			clientes.add(clienteTmp);
		}
		return clienteTmp;
	}
}
