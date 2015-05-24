package dao.component;

import dao.design.ICuentaDAO;
import dao.ds.AccesoDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaDAO implements ICuentaDAO {

	public void deposito(String cuenta, Double importe, String empleado) throws Exception {
		String query = "{call usp_deposito(?,?,?,?)}";
		Connection cn = AccesoDB.getConnection();
		cn.setAutoCommit(true);
		CallableStatement cs = cn.prepareCall(query);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, cuenta);
		cs.setDouble(3, importe);
		cs.setString(4, empleado);
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new Exception(estado);
		}
	}

	public void retiro(String cuenta, String clave, Double importe, String empleado) throws Exception {
		String query = "{call usp_retiro(?,?,?,?,?)}";
		Connection cn = AccesoDB.getConnection();
		cn.setAutoCommit(true);
		CallableStatement cs = cn.prepareCall(query);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, cuenta);
		cs.setString(3, clave);
		cs.setDouble(4, importe);
		cs.setString(5, empleado);
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new Exception(estado);
		}
	}

	public boolean existe(String cuenta) throws Exception {
		String sql = "select count(*) as dato from cuenta where chr_cuencodigo = ?";
		PreparedStatement ps = AccesoDB.getConnection().prepareStatement(sql);
		ps.setString(1, cuenta);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int dato = rs.getInt("dato");
		return (dato == 1);
	}
}