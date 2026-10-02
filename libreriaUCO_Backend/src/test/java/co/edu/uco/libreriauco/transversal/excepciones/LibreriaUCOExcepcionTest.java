package co.edu.uco.libreriauco.transversal.excepciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

class LibreriaUCOExcepcionTest {

	@Test
	void crearSoloConMensajeUsuarioDebeUsarElMismoMensajeComoTecnico() {
		LibreriaUCOExcepcion excepcion = LibreriaUCODatosExcepcion.crear("Error de usuario");

		assertEquals("Error de usuario", excepcion.getMensajeUsuario());
		assertEquals("Error de usuario", excepcion.getMensajeTecnico());
	}

	@Test
	void crearConMensajeTecnicoDebeConservarAmbosMensajes() {
		LibreriaUCOExcepcion excepcion = LibreriaUCODatosExcepcion.crear("Error de usuario", "Fallo SQL");

		assertEquals("Error de usuario", excepcion.getMensajeUsuario());
		assertEquals("Fallo SQL", excepcion.getMensajeTecnico());
	}

	@Test
	void crearConExcepcionRaizDebeConservarLaCausaYLaCapa() {
		Exception raiz = new IllegalStateException("causa");

		LibreriaUCOExcepcion excepcion = LibreriaUCODatosExcepcion.crear("Error de usuario", "Fallo SQL", raiz);

		assertEquals("Fallo SQL", excepcion.getMensajeTecnico());
		assertSame(raiz, excepcion.getExcepcionRaiz());
		assertEquals(Capa.DATOS, excepcion.getCapa());
	}
}
