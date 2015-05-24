package egcc.pruebas;

import egcc.accesodb.AccesoDB;
import java.sql.*;

public class Test01 {

	public static void main(String[] args) {

		Connection cn = null;
		CallableStatement cs = null;
		String sql = "{call usp_actualiza_datos_cliente(?,?,?,?,?,?,?,?,?,?)}";
		String nulo = null;
		String estado = null;

		try {
			
			cn = AccesoDB.getConnection();
			cn.setAutoCommit( true ); // Por que la transacción se maneja en el servidor
			
			cs = cn.prepareCall(sql);
			
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.setString(2, "00021");
			//cs.setString(3, "GUARACHI");
			cs.setString(3, nulo);
			cs.setString(4, "CORONEL");
			cs.setString(5, "ALEJANDRA MARIEL");
			cs.setString(6, "10459823");
			cs.setString(7, "PACHERREZ");
			cs.setString(8, "CASA CASTILLO");
			cs.setString(9, "2398456");
			cs.setString(10, "aguarachi@perudev.com");
			
			cs.executeUpdate();
			estado = cs.getString(1);
			
			if( estado != null ){
				throw new Exception(estado);
			}
			
			cn.close();
			System.out.println("Proceso Ok");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}
}