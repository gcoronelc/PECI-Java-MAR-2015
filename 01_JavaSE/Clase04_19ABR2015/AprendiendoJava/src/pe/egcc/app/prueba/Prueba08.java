package pe.egcc.app.prueba;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba08 {

  public static void main(String[] args) {
    PrintStream printStream = null;
    try {
      String fileName = Isil.RUTA_BASE + "Archivo.txt";
      FileOutputStream stream = new FileOutputStream(fileName, true);
      printStream = new PrintStream(stream);
      printStream.println("Este es un nuevo texto");
      printStream.println("Este es otro nuevo texto");
      System.out.println("Todo ok.");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        printStream.close();
      } catch (Exception e) {
      }
    }
  }

}
