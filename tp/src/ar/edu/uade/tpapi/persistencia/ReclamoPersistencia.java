package ar.edu.uade.tpapi.persistencia;

public class ReclamoPersistencia {

	private static ReclamoPersistencia instancia;
	
	private ReclamoPersistencia() {
	}

	public static ReclamoPersistencia getInstance(){
		return (instancia!=null) ? instancia : new ReclamoPersistencia();
	}
	
	public long ultimoNumero(){
		return 0;
	}
}
