package ar.edu.uade.tpapi.modelo;

import ar.edu.uade.tpapi.persistencia.ClientePersistencia;

public class Cliente {

	private long idCliente;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private boolean activo;
	
	public Cliente(String nombre, String domicilio, String telefono, String mail) {
		super();
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.mail=mail;
		this.activo=true;
		this.idCliente=ClientePersistencia.getInstance().insertGetId(this);
	}
	
	public Cliente(long idCliente, String nombre, String domicilio, String telefono, String mail, boolean activo) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.activo = activo;
	}
		
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}