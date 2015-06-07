package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.app.db.AccesoDB;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba04 {

  public static void main(String[] args) {
    Connection cn = null;
    //String coCliente = "00016";
    String coCliente = "' OR '1'='1";
    try {
      cn = AccesoDB.getConnection();
      String sql = "select * from cliente where chr_cliecodigo = ?";
      PreparedStatement ps = cn.prepareStatement(sql);
      ps.setString(1, coCliente);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        System.out.println(rs.getString("chr_cliecodigo") 
                + " - " + rs.getString("vch_clienombre")
                + " - " + rs.getString("vch_cliepaterno")
                + " - " + rs.getString("vch_cliematerno"));
      }
      rs.close();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(cn != null) cn.close();
      } catch (Exception e) {
      }
    }
  }
  
}
