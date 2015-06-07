package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Probando la conexión con Oracle.
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    try {
      // Datos de Conexión
      String driver = "oracle.jdbc.OracleDriver";
      String urlDB = "jdbc:oracle:thin:@172.17.45.25:1521:XE";
      String user = "eureka";
      String password = "admin";
      // Proceso
      Class.forName(driver).newInstance();
      Connection cn = DriverManager.getConnection(urlDB, user, password);
      System.out.println("Conexión ok.");
      cn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
