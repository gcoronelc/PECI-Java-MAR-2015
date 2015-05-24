package cap13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo1302 {

	public static void main(String[] args) {

		// Define la variable de tipo Connection
		Connection conn = null;

		// Inicia el manejo de errores estándar
		try {

			//Load a driver with Class.forName.
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			System.out.println("Abriendo la conexión con la base de datos...");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@egcc:1521:XE", "gustavo", "cerebro");

		// Manejando errores JDBC
		} catch (SQLException se) {
			se.printStackTrace();
		// Manejando otros tipos de excepciones
		} catch (Exception e) {
			e.printStackTrace();
		// Bloque finally usado para cerrar la conexión
		} finally {
			try {
				if (conn != null) {
					String msg = "Cerrando la conexión desde el bloque finally.";
					System.out.println(msg);
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}// Fin de try en el bloque finally
			
		} // Fin de try
		
	} // Fin del método main
	
} // Fin de la clase Ejemplo0902