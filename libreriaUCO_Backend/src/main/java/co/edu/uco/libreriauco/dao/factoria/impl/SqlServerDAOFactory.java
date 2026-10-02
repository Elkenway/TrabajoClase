package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory {

	@Override
	protected void abrirConexion() {
		try {
			// 1. Definir los parámetros de conexión
			// Asegúrate de cambiar "localhost", "1433" y "NombreTuBaseDeDatos" por tus datos reales
			String cadenaConexion = "jdbc:sqlserver://localhost:1433;databaseName=LibreriaUco;encrypt=true;trustServerCertificate=true;";
			String usuario = "tu_usuario_sql";
			String clave = "tu_contraseña_sql";
			
			// 2. Obtener la conexión utilizando el Driver Manager
			Connection conexionSqlServer = DriverManager.getConnection(cadenaConexion, usuario, clave);
			
			// 3. Asignar la conexión utilizando el método de la clase padre que ya la valida
			setConexion(conexionSqlServer);
			
		} catch (SQLException e) {
			// Si falla la conexión, se captura la excepción SQL y se lanza una excepción de ejecución
			throw new RuntimeException("Error al intentar abrir la conexión con la base de datos SQL Server.", e);
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		// Aquí idealmente le pasarías la conexión a tu DAO, por ejemplo:
		// return new PaisSqlServerDAO(getConexion());
		return new PaisSqlServerDAO();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		// Igual aquí
		return new DepartamentoSqlServerDAO();
	}

}