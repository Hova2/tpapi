package ar.edu.uade.tpapi.vista;

public class ClienteView {

	private long dniCliente;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private boolean activo;
	
	public ClienteView(long dniCliente, String nombre, String domicilio,
			String telefono, String mail, boolean activo) {
		super();
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.activo = activo;
	}

	public long getDniCliente() {
		return dniCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public boolean isActivo() {
		return activo;
	}
}
