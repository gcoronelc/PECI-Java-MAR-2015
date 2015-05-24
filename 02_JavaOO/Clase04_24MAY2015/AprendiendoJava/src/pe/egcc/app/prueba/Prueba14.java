package pe.egcc.app.prueba;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Map tipificados.
 * Es usual tipificar la clave como tipo String.
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba14 {
  
  public static void main(String[] args) {

    Map<String,Object> rec = new HashMap<>();
    
    rec.put("codigo", "C00056");
    rec.put("nombre", "Azucar");
    rec.put("precio", 4.15);
    rec.put("stock", 10000);
    
    rec.keySet().stream().forEach
        (key -> System.out.println(key + " ==> " +rec.get(key)));
    
  }

}
