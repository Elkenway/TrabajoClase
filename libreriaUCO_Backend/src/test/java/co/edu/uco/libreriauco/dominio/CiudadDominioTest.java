package co.edu.uco.libreriauco.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

class CiudadDominioTest {

	@Test
	void builderSinDatosDebeUsarLosValoresPorDefecto() {
		CiudadDominio ciudad = new CiudadDominio.Builder().build();

		assertEquals(UtilUUID.VALOR_DEFECTO, ciudad.getId());
		assertEquals(UtilTexto.VACIA, ciudad.getNombre());
		assertNotNull(ciudad.getDepartamento());
	}

	@Test
	void builderDebeQuitarEspaciosEnBlancoDelNombre() {
		CiudadDominio ciudad = new CiudadDominio.Builder().nombre("   Medellin   ").build();

		assertEquals("Medellin", ciudad.getNombre());
	}

	@Test
	void builderDebeAsociarElDepartamentoRecibido() {
		DepartamentoDominio antioquia = new DepartamentoDominio.Builder().nombre("Antioquia").build();

		CiudadDominio ciudad = new CiudadDominio.Builder()
				.nombre("Medellin")
				.departamento(antioquia)
				.build();

		assertEquals("Antioquia", ciudad.getDepartamento().getNombre());
	}

	@Test
	void departamentoNuloDebeCaerAUnoPorDefectoYNoLanzarExcepcion() {
		CiudadDominio ciudad = new CiudadDominio.Builder().departamento(null).build();

		assertNotNull(ciudad.getDepartamento());
		assertEquals(UtilTexto.VACIA, ciudad.getDepartamento().getNombre());
	}
}
