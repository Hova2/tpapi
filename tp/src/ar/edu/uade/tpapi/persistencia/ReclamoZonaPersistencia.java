package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class ReclamoZonaPersistencia extends AdministradorPersistencia {

	private static ReclamoZonaPersistencia instancia;
	
	public ReclamoZonaPersistencia() {
	}

	public static ReclamoZonaPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoZonaPersistencia();
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
