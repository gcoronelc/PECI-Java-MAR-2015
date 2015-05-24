package cap14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1402 {

	public static void main(String[] args) {
		
		// Variables
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean existe = false;
		String sql = "select * from empleado";

		// Proceso
		try {
			// Establecemos la conexión
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost/eurekabank", "root", "admin");
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while( rs.next() ) {
				existe = true;
				System.out.println(rs.getString("vch_emplnombre") + " " + rs.getString("vch_emplpaterno"));
			}
			if( !existe )
				System.out.println("No se encontraron datos.");
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


	} // Fin del método main
}
