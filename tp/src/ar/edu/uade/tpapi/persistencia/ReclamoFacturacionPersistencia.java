package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public class ReclamoFacturacionPersistencia extends AdministradorPersistencia {

private static ReclamoFacturacionPersistencia instancia;
	
	private ReclamoFacturacionPersistencia() {
	}

	public static ReclamoFacturacionPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoFacturacionPersistencia();
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
