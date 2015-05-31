package pe.egcc.app.prueba;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba05 {

  public static void main(String[] args) {
    Connection cn = null;
    String cuenta = "0010000244";
    try {
      cn = AccesoDB.getConnection();
      String sql = "{call usp_egcc_saldo_cuenta(?,?)}";
      CallableStatement cs = cn.prepareCall(sql);
      cs.setString(1, cuenta);
      cs.registerOutParameter(2, Types.DECIMAL);
      cs.executeUpdate();
      double saldo = cs.getDouble(2);
      System.out.println("SALDO: " + saldo);
      cs.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (cn != null) {
          cn.close();
        }
      } catch (Exception e) {
      }
    }
  }
}
