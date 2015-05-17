package pe.egcc.app.prueba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba09 {

  public static void main(String[] args) {
    FileReader fileReader = null;
    try {
      String fileName = Isil.RUTA_BASE + "Archivo.txt";
      fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String linea = bufferedReader.readLine(); // La primera línea
      int cont = 0;
      while (linea != null) {
        cont++;
        System.out.println("Linea " + cont + ": " + linea);
        linea = bufferedReader.readLine(); // A partir de la segunda línea
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        fileReader.close();
      } catch (Exception e) {
      }
    }

  }
  
}
