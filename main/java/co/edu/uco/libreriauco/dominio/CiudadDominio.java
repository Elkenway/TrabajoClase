package co.edu.uco.libreriauco.dominio;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadDominio {

	private UUID id;
	private String nombre;
	private DepartamentoDominio departamento;

	private CiudadDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.departamento = builder.departamento;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DepartamentoDominio getDepartamento() {
		return departamento;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		private DepartamentoDominio departamento;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIA;
			departamento = new DepartamentoDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder departamento(DepartamentoDominio departamento) {
			this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento, new DepartamentoDominio.Builder().build());
			return this;
		}

		public CiudadDominio build() {
			return new CiudadDominio(this);
		}
	}

}
