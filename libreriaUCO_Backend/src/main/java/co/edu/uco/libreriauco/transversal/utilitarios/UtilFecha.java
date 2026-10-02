package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.LocalDate;

public class UtilFecha {

	public static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);

	private UtilFecha() {
	}

	public static LocalDate obtenerValorDefecto(final LocalDate fecha, final LocalDate valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fecha, valorDefecto);
	}

	public static LocalDate obtenerValorDefecto(final LocalDate fecha) {
		return obtenerValorDefecto(fecha, FECHA_DEFECTO);
	}
}
