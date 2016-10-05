package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class ReclamoProductoPersistencia extends AdministradorPersistencia {

	private static ReclamoProductoPersistencia instancia;
	
	private ReclamoProductoPersistencia() {
	}

	public static ReclamoProductoPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoProductoPersistencia();
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
