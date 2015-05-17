package pe.egcc.app.prueba;

import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.PrintStream;
import pe.egcc.app.model.Articulo;
import pe.egcc.app.util.Isil;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba12 {

  public static void main(String[] args) {
     String fileName = Isil.RUTA_BASE + "Articulos.txt";
     
     PrintStream printStream = null;
    try {
      FileOutputStream stream = new FileOutputStream(fileName, true);
      printStream = new PrintStream(stream);
      
      Articulo a = new Articulo("Juego de Sala 3-2-1", 2500.00);
      Gson gson = new Gson();
      printStream.println(gson.toJson(a));
   
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
