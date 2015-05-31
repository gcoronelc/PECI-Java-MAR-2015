package pe.egcc.app.prueba;

import java.sql.Connection;
import pe.egcc.app.db.AccesoDB;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba02 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      System.out.println("Conexión ok.");
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
