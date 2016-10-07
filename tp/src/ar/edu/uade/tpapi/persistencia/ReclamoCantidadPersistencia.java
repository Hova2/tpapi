package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class ReclamoCantidadPersistencia extends AdministradorPersistencia {

private static ReclamoCantidadPersistencia instancia;
	
	private ReclamoCantidadPersistencia() {
	}

	public static ReclamoCantidadPersistencia getInstance(){
		if (instancia==null){
			instancia=new ReclamoCantidadPersistencia();
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
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
