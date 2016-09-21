package ar.edu.uade.tpapi.modelo;

import java.util.Vector;

public abstract class Rol {

	private Vector<Usuario> usuarios=new Vector<Usuario>();
	
	public Rol() {
		super();
	}

	public Vector<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
