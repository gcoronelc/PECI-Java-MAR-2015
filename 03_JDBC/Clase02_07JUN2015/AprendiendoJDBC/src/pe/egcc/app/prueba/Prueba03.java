package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    Connection cn = null;
    //String coCliente = "00016";
    String coCliente = "' OR '1'='1";
    try {
      cn = AccesoDB.getConnection();
      String sql = "select * from cliente "
              + "where chr_cliecodigo='" + coCliente +"'";
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
        System.out.println(rs.getString("chr_cliecodigo") 
                + " - " + rs.getString("vch_clienombre")
                + " - " + rs.getString("vch_cliepaterno")
                + " - " + rs.getString("vch_cliematerno"));
      }
      rs.close();
      stm.close();
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
