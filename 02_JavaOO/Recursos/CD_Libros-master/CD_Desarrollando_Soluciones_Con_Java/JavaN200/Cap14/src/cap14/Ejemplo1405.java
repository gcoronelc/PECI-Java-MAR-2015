package cap14;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo1405 {

	public static void main(String args[]) {

		// Variables
		String sql = "{call usp_consulta_saldo_de_cuenta(?)}";
		Connection cn = null;
		CallableStatement cs = null;
		Double saldo;

		// Proceso
		try {
			// Establecemos la conexión
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost/eurekabank", "root", "admin");
			// Preparamos la llamada
			cs = cn.prepareCall(sql);
			cs.setString(1, "00200001");
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			// Realizamos la llamada
			cs.execute();
			// Obtenemos el valor del parámetro de salida
			saldo = Double.parseDouble(cs.getString(1));
			if (cs.wasNull()) {
				System.out.println("Cuenta no existe.");
			} else {
				System.out.println("Saldo: " + saldo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cn.isClosed() == false) {
					cn.close();
				}
			} catch (SQLException ex) {
			}
		}
	} // Main
} // Ejemplo1405
