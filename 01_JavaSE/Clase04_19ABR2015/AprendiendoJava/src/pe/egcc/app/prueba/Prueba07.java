package pe.egcc.app.prueba;

import java.io.PrintStream;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba07 {

  public static void main(String[] args) {
    PrintStream printStream = null;
    try {
      //String fileName = Isil.RUTA_BASE + "Archivo.txt";
      String fileName = Isil.grabarDialogoFileText();
      System.out.println(fileName);
      printStream = new PrintStream(fileName);
      printStream.println("Este es un texto");
      printStream.println("Este es otro texto");
      System.out.println("Todo ok.");
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      try {
        printStream.close();
      } catch (Exception e) {
      }
    }
  }

}
