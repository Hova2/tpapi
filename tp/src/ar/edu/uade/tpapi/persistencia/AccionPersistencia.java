package ar.edu.uade.tpapi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ar.edu.uade.tpapi.modelo.Accion;

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
