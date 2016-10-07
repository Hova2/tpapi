package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class UsuarioPersistencia extends AdministradorPersistencia {

	private static UsuarioPersistencia instancia;
	
	private UsuarioPersistencia() {
	}
	
	public static UsuarioPersistencia getInstance(){
		if (instancia==null){
			instancia=new UsuarioPersistencia();
		}
		return instancia;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
}
