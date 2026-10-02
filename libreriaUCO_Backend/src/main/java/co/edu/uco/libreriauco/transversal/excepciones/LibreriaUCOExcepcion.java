package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class LibreriaUCOExcepcion extends RuntimeException{

	private static final long serialVersionUID = -3141765983563781140L;
	private Capa capa;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception ExcepcionRaiz;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Capa getCapa() {
		return capa;
	}
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public Exception getExcepcionRaiz() {
		return ExcepcionRaiz;
	}
	private void setCapa(Capa capa) {
		this.capa = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(capa, Capa.GENERAL);
	}
	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeUsuario);
	}
	private void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeTecnico, getMensajeUsuario());
	}
	private void setExcepcionRaiz(Exception excepcionRaiz) {
		ExcepcionRaiz = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(excepcionRaiz, new Exception(mensajeTecnico));
	}
	protected LibreriaUCOExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super();
		setCapa(capa);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setExcepcionRaiz(excepcionRaiz);
	}
	

}
