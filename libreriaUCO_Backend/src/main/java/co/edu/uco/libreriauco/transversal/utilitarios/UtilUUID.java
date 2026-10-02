package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;

public class UtilUUID {
	
	public static final UUID VALOR_DEFECTO  = UUID.fromString("00000000-0000-0000-0000-000000000000");
	
	private UtilUUID () {
	}
	
	public static final UUID obtenerValorDefecto(final UUID id, final UUID valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(id, valorDefecto);
	}
	
	public static final UUID obtenerValorDefecto(final UUID id) {
		return obtenerValorDefecto(id, VALOR_DEFECTO);
	}

}
