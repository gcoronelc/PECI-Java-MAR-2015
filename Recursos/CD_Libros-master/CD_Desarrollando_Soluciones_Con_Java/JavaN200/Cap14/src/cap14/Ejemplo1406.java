package cap14;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo1406 {

	public static void main(String args[]) {

		// Variables
		String sql = "{call usp_consultar_clientes_por_distrito(?)}";
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		boolean existe = false;

		// Proceso
		try {
			
			// Establecemos la conexión
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost/eurekabank", "root", "admin");
			cs = cn.prepareCall(sql);
			cs.setString(1, "LINCE");
			rs = cs.executeQuery();
			
			while (rs.next()) {
				existe = true;
				System.out.println(rs.getString("codigo") + " " + rs.getString("nombre"));
			}
			if (!existe) {
				System.out.println("No se encontraron datos.");
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
} // Ejemplo1406