package pe.egcc.app.prueba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pe.egcc.app.util.AppUtil;

/**
 * Lista tipificada
 * Solo se puede tener datos del tipo especificado
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba09 {

  public static void main(String[] args) {
    
    List<String> ciudades = new ArrayList<>();
    
    ciudades.add("Chiclayo");
    ciudades.add("Trujillo");
    ciudades.add("Cuzco");
    ciudades.add("Arequipa");
    ciudades.add("Huancayo");
    ciudades.add("Huanuco");
    ciudades.add("Iquitos");
    
    AppUtil.mostrar(ciudades);
    
    // Tecnica: Clase anonima
    ciudades.sort(new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    });
    
    AppUtil.mostrar(ciudades);
    
  }
  
}
