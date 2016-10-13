package ar.edu.uade.tpapi.modelo;

import ar.edu.uade.tpapi.persistencia.UsuarioPersistencia;
import ar.edu.uade.tpapi.vista.UsuarioView;

public class Usuario {

	private long idUsuario;
	private String nombre;
	private String password;
	private int rol;
		
	public Usuario(long idUsuario, String nombre, String password, int rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdUsuario() {
		return idUsuario;
	}
		
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public boolean soyUsuario(String nombre){
		return this.nombre == nombre;
	}
	
	public UsuarioView crearViewUsuario(){
		UsuarioView usuarioViewTmp = new UsuarioView(this.idUsuario, this.nombre, this.password, this.rol); 
		return usuarioViewTmp;
	}
	
	public static Usuario recuperarUsuario(String nombre){
		return UsuarioPersistencia.getInstance().recuperarUsuario(nombre);
	}
}
