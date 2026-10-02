package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilNumero {

	public static final int CERO = 0;

	private UtilNumero() {

	}

	public static <N extends Number> N obtenerValorDefecto (N valor, N valorDefecto){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static <N extends Number> Number obtenerValorDefecto (N valor){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, CERO);
	}

	public static <N extends Number> boolean mayorQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() > obtenerValorDefecto(numeroDos).doubleValue();
	}

	public static <N extends Number> boolean menorQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() < obtenerValorDefecto(numeroDos).doubleValue();
	}

	public static <N extends Number> boolean diferenteQue(N numeroUno, N numeroDos) {
		return obtenerValorDefecto(numeroUno).doubleValue() != obtenerValorDefecto(numeroDos).doubleValue();
	}

	public static <N extends Number> boolean estaEntreSinIncluirRangos(N numero, N rangoInicial, N rangoFinal
			) {
		return obtenerValorDefecto(numero).doubleValue() > obtenerValorDefecto(rangoInicial).doubleValue() &&
				obtenerValorDefecto(numero).doubleValue() < obtenerValorDefecto(rangoFinal).doubleValue() ;
	}

	public static <N extends Number> boolean estaEntreIncluyendoRangoInicial(N numero, N rangoInicial, N rangoFinal
			) {
		return obtenerValorDefecto(numero).doubleValue() >= obtenerValorDefecto(rangoInicial).doubleValue() &&
				obtenerValorDefecto(numero).doubleValue() < obtenerValorDefecto(rangoFinal).doubleValue() ;
	}

	public static <N extends Number> boolean estaEntreIncluyendoRangoFinal(N numero, N rangoInicial, N rangoFinal
			) {
		return obtenerValorDefecto(numero).doubleValue() > obtenerValorDefecto(rangoInicial).doubleValue() &&
				obtenerValorDefecto(numero).doubleValue() <= obtenerValorDefecto(rangoFinal).doubleValue() ;
	}

	public static <N extends Number> boolean estaEntreIncluyendoRangos(N numero, N rangoInicial, N rangoFinal
			) {
		return obtenerValorDefecto(numero).doubleValue() >= obtenerValorDefecto(rangoInicial).doubleValue() &&
				obtenerValorDefecto(numero).doubleValue() <= obtenerValorDefecto(rangoFinal).doubleValue() ;
	}

}
