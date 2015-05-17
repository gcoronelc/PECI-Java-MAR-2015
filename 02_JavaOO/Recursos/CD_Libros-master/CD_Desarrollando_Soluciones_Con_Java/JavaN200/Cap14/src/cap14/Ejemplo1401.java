package cap14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1401 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from empleado where chr_emplcodigo = '0001'";
		
		// Proceso
		try {
			// Establecemos la conexión
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost/eurekabank", "root", "admin");
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if( rs.next())
				System.out.println( "Empleado: " + rs.getString("vch_emplnombre") + " " + rs.getString("vch_emplpaterno") );
			else
				System.out.println("Código no existe.");
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
	
} // Fin de la clase Ejemplo1401

