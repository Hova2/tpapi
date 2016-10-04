package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class AccionPersistencia extends AdministradorPersistencia {

	private static AccionPersistencia instancia;
	
	public AccionPersistencia() {
	}

	public static AccionPersistencia getInstance(){
		return (instancia!=null) ? instancia : new AccionPersistencia();
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
	
	public long ultimoNumero(){
		return 0;
	}

}
