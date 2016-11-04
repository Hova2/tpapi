package ar.edu.uade.tpapi.modelo;

import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ProductoPersistencia;
import ar.edu.uade.tpapi.vista.ProductoView;

public class Producto {

	private long codigo;
	private String titulo;
	private String descripcion;
	private float precio;
	private boolean activo;
	
	public Producto(long codigo, String titulo, String descripcion, float precio) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.activo = true;
		ProductoPersistencia.getInstance().insert(this);
	}

	public Producto(long codigo, String titulo, String descripcion,
			float precio, boolean activo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
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
	
	public boolean soyProducto(long codigo){
		return this.codigo == codigo;
	}
	
	public ProductoView crearViewProducto(){
		ProductoView prodViewTmp = new ProductoView(this.codigo, this.titulo, this.descripcion, this.precio, this.activo);
		return prodViewTmp;
	}
	
	public static Producto recuperarProducto(long codigo){
		return ProductoPersistencia.getInstance().recuperarProducto(codigo);
	}

	public static Vector<Producto> recuperarProductos() {
		return ProductoPersistencia.getInstance().recuperarProductos();
	}
}
