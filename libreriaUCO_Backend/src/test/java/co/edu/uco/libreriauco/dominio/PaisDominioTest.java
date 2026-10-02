package co.edu.uco.libreriauco.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

class PaisDominioTest {

	@Test
	void builderSinDatosDebeUsarLosValoresPorDefecto() {
		PaisDominio pais = new PaisDominio.Builder().build();

		assertEquals(UtilUUID.VALOR_DEFECTO, pais.getId());
		assertEquals(UtilTexto.VACIA, pais.getNombre());
	}

	@Test
	void builderDebeQuitarEspaciosEnBlancoDelNombre() {
		PaisDominio pais = new PaisDominio.Builder().nombre("   Colombia   ").build();

		assertEquals("Colombia", pais.getNombre());
	}

	@Test
	void idNuloDebeCaerAlValorPorDefectoYNoLanzarExcepcion() {
		PaisDominio pais = new PaisDominio.Builder().id(null).build();

		assertEquals(UtilUUID.VALOR_DEFECTO, pais.getId());
	}

	@Test
	void nombreNuloDebeCaerEnCadenaVaciaYNoLanzarExcepcion() {
		PaisDominio pais = new PaisDominio.Builder().nombre(null).build();

		assertEquals(UtilTexto.VACIA, pais.getNombre());
	}
}
