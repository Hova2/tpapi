package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class AccionPersistencia extends AdministradorPersistencia {

	private static AccionPersistencia instancia;
	
	public AccionPersistencia() {
	}

	public static AccionPersistencia getInstance(){
		if (instancia==null){
			instancia=new AccionPersistencia();
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
	
	public long ultimoNumero(){
		return 0;
	}

}
