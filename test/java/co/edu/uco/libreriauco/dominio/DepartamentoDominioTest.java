package co.edu.uco.libreriauco.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

class DepartamentoDominioTest {

	@Test
	void builderSinDatosDebeUsarLosValoresPorDefecto() {
		DepartamentoDominio departamento = new DepartamentoDominio.Builder().build();

		assertEquals(UtilUUID.VALOR_DEFECTO, departamento.getId());
		assertEquals(UtilTexto.VACIA, departamento.getNombre());
		assertNotNull(departamento.getPais());
		assertEquals(UtilUUID.VALOR_DEFECTO, departamento.getPais().getId());
	}

	@Test
	void builderDebeQuitarEspaciosEnBlancoDelNombre() {
		DepartamentoDominio departamento = new DepartamentoDominio.Builder().nombre("   Antioquia   ").build();

		assertEquals("Antioquia", departamento.getNombre());
	}

	@Test
	void builderDebeAsociarElPaisRecibido() {
		PaisDominio colombia = new PaisDominio.Builder().nombre("Colombia").build();

		DepartamentoDominio departamento = new DepartamentoDominio.Builder()
				.nombre("Antioquia")
				.pais(colombia)
				.build();

		assertEquals("Colombia", departamento.getPais().getNombre());
	}

	@Test
	void paisNuloDebeCaerAUnPaisPorDefectoYNoLanzarExcepcion() {
		DepartamentoDominio departamento = new DepartamentoDominio.Builder().pais(null).build();

		assertNotNull(departamento.getPais());
		assertEquals(UtilTexto.VACIA, departamento.getPais().getNombre());
	}
}
