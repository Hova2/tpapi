package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class ReclamoFaltantePersistencia extends AdministradorPersistencia {
	
	private static ReclamoFaltantePersistencia instancia;
	
	private ReclamoFaltantePersistencia() {
	}

	public static ReclamoFaltantePersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoFaltantePersistencia();
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
