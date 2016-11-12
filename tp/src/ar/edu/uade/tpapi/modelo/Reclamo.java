package ar.edu.uade.tpapi.modelo;

import java.util.Vector;

import ar.edu.uade.tpapi.persistencia.ReclamoPersistencia;

public abstract class Reclamo {

	private static long nroUltimoReclamo=-1;
	private long nroReclamo;
	
	public Reclamo() {
		super();
		this.nroReclamo = this.buscaNroUltimoReclamo();
	}
	
	public Reclamo(long nroReclamo){
		this.nroReclamo = nroReclamo;
	}
	
	public long getNroReclamo() {
		return nroReclamo;
	}
	
	public boolean soyReclamo(long nroReclamo){
		return this.nroReclamo == nroReclamo;
	}
	
	public static Reclamo recuperarReclamo(long nroReclamo){
		Reclamo reclamoTmp = ReclamoPersistencia.getInstance().recuperarReclamo(nroReclamo);
		return reclamoTmp;
	}
	
	public static Vector<Reclamo> recuperarReclamos(){
		Vector<Reclamo> reclamosTmp = ReclamoPersistencia.getInstance().recuperarReclamos();
		return reclamosTmp;
	}
	
	public static Vector<Cliente> rankingClientes(){
		return null;
	}
	
	private long buscaNroUltimoReclamo(){
		if (nroUltimoReclamo==-1){
			nroUltimoReclamo=ReclamoPersistencia.getInstance().ultimoNumero();
		}
		return ++nroUltimoReclamo;
	}
}
