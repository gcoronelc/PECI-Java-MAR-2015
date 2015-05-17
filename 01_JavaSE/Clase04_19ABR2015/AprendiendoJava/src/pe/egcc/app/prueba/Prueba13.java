package pe.egcc.app.prueba;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import pe.egcc.app.model.Articulo;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba13 {

  public static void main(String[] args) {
    FileReader fileReader = null;
    try {
      String fileName = Isil.RUTA_BASE + "Articulos.txt";
      fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String linea = bufferedReader.readLine(); // La primera línea
      Gson gson = new Gson();
      while (linea != null) {
        if(!linea.isEmpty()){
          Articulo a = gson.fromJson(linea, Articulo.class);
          System.out.println(a.getNombre() + " " + a.getPrecio());
        }
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
