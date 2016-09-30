package ar.edu.uade.tpapi.controlador;

import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Cliente;
import ar.edu.uade.tpapi.persistencia.ClientePersistencia;
import ar.edu.uade.tpapi.vista.ClienteView;

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
	
	public Vector<ClienteView> listarClientes(){
		Vector<Cliente> clientesTmp=ClientePersistencia.getInstance().selectAll();
		Vector<ClienteView> clientesViewTmp=new Vector<ClienteView>();
		if (clientesTmp!=null){
			for(int i=0;i<clientesTmp.size();i++){
				ClienteView cliViewTmp=clientesTmp.get(i).crearViewCliente();
				clientesViewTmp.add(cliViewTmp);
			}
		}
		return clientesViewTmp;
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
