package ar.edu.uade.tpapi.vista;

public class ProductoView {
	
	private long codigo;
	private String titulo;
	private String descripcion;
	private float precio;
	private boolean activo;
	
	public ProductoView(long codigo, String titulo, String descripcion,
			float precio, boolean activo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.activo = activo;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public boolean isActivo() {
		return activo;
	}
}
