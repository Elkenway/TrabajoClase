package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;

public abstract class DAOFactory {
	
	private Connection conexion;
	
	protected DAOFactory() {
		abrirConexion();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		try {
			// Asegurar que la conexión no sea nula y esté abierta
			if (conexion == null || conexion.isClosed()) {
				throw new RuntimeException("La conexión no puede ser nula ni estar cerrada.");
			}
			this.conexion = conexion;
		} catch (SQLException e) {
			throw new RuntimeException("Error al validar el estado de la conexión.", e);
		}
	}
	
	protected abstract void abrirConexion(); 
	
	public void cerrarConexion() {
		try {
			// Validar que exista la conexión y esté abierta antes de intentar cerrarla
			if (this.conexion != null && !this.conexion.isClosed()) {
				this.conexion.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error inesperado al intentar cerrar la conexión.", e);
		}
	}
	
	public void iniciarTransacción() {
		try {
			if (this.conexion != null && !this.conexion.isClosed()) {
				// Desactivar el autocommit inicia la transacción manual
				this.conexion.setAutoCommit(false);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al intentar iniciar la transacción.", e);
		}
	}
	
	public void confirmarTransacción() {
		try {
			if (this.conexion != null && !this.conexion.isClosed()) {
				// Confirmar los cambios en la base de datos
				this.conexion.commit();
				// Buena práctica: devolver la conexión a su estado original
				this.conexion.setAutoCommit(true); 
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al intentar confirmar la transacción.", e);
		}
	}
	
	public void cancelarTransacción() {
		try {
			if (this.conexion != null && !this.conexion.isClosed()) {
				// Revertir los cambios en la base de datos
				this.conexion.rollback();
				// Buena práctica: devolver la conexión a su estado original
				this.conexion.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al intentar cancelar la transacción.", e);
		}
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();

}
