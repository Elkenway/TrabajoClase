package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

	private UUID id;
	private String nombre;
	private PaisEntidad pais;

	public DepartamentoEntidad() {
		setId(UtilUUID.VALOR_DEFECTO);
		setNombre(UtilTexto.VACIA);
		setPais(new PaisEntidad());
	}
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
	}
	
	public PaisEntidad getPais() {
		return pais;
	}

	public void setPais(PaisEntidad pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new PaisEntidad());
	}
}
