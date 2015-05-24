package dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gustavo Coronel
 */
public class AccesoDB {

	private static Connection connection = null;

	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/eurekabank";
		String user = "root";
		String pwd = "";
		if (connection == null) {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, user, pwd);
		}
		return connection;
	} // getConection
}