package ar.edu.uade.tpapi.modelo;

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

	private long buscaNroUltimoReclamo(){
		if (nroUltimoReclamo==-1){
			nroUltimoReclamo=ReclamoPersistencia.getInstance().ultimoNumero();
		}
		return ++nroUltimoReclamo;
	}
}
