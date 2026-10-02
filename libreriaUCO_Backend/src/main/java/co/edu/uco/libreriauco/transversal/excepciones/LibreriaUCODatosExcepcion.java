package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODatosExcepcion extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -3789453764295582052L;

	private LibreriaUCODatosExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCODatosExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCODatosExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new LibreriaUCODatosExcepcion(mensajeUsuario, mensajeTecnico, exceptcionRaiz);
	}

}
