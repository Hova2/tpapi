package ar.edu.uade.tpapi.vista;

public class UsuarioView {

	private long idUsuario;
	private String nombre;
	private String password;
	private int rol;
	
	public UsuarioView(long idUsuario, String nombre, String password, int rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public int getRol() {
		return rol;
	}
}
