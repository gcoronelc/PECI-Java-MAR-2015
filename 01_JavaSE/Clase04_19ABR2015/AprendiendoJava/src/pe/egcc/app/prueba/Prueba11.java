package pe.egcc.app.prueba;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import pe.egcc.app.model.Articulo;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba11 {

  public static void main(String[] args) {
    try {
      String fileName = Isil.RUTA_BASE + "Datos.dat";
      InputStream file = new FileInputStream(fileName);
      InputStream buffer = new BufferedInputStream(file);
      ObjectInput input = new ObjectInputStream(buffer);
      Articulo bean;
      while (true) {
        try {
          bean = (Articulo) input.readObject();
        } catch (Exception e) {
          break; // Sale del bucle
        }
        System.out.println(bean.getNombre() + " - " + bean.getPrecio());
      }
      input.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
