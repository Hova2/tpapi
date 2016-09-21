package ar.edu.uade.tpapi.persistencia;

import java.util.Vector;

public abstract class AdministradorPersistencia 
{
	//public abstract void insertSetId (Object o);
	//public abstract long insertGetId (Object o);
	public abstract void update (Object o);
	public abstract void delete (Object d);
	public abstract Vector<Object> select (Object o);
}
