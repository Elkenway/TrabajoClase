package co.edu.uco.libreriauco.dao.datos;

public interface ActualizarDAO <E, ID>{
	void actualizar (ID id, E entidad);
}
