package ar.edu.uade.tpapi.modelo;

public class Usuario {

	private long idUsuario;
	private String nombre;
	private String login;
	private boolean activo;
	
	public Usuario(String nombre, String login) {
		super();
		//this.idUsuario = UsuarioPersistencia.getInstance().insert(this);
		this.nombre = nombre;
		this.login = login;
		this.activo=true;
	}
		
	public Usuario(long idUsuario, String nombre, String login, boolean activo) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.login = login;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getIdUsuario() {
		return idUsuario;
	}
		
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
