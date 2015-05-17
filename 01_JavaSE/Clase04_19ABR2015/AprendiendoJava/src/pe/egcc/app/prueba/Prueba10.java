package pe.egcc.app.prueba;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import pe.egcc.app.model.Articulo;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba10 {

  public static void main(String[] args) {
    try {
      String fileName = Isil.RUTA_BASE + "Datos.dat";
      OutputStream file = new FileOutputStream(fileName);
      OutputStream buffer = new BufferedOutputStream(file);
      ObjectOutput output = new ObjectOutputStream(buffer);
      output.writeObject(new Articulo("Art1", 34.5));
      output.writeObject(new Articulo("Art2", 56.2));
      output.writeObject(new Articulo("Art3", 67.43));
      output.writeObject(new Articulo("Art4", 34.67));
      output.writeObject(new Articulo("Art5", 23.56));
      output.writeObject(new Articulo("Art6", 77.34));
      System.out.println("Todo ok.");
      output.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
