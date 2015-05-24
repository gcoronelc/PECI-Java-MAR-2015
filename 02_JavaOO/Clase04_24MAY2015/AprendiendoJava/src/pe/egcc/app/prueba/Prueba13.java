package pe.egcc.app.prueba;

import java.util.HashMap;
import java.util.Map;

/**
 * Map genericos
 * Un Map es un par de datos: Clave -> Valor
 * Las claves no se pueden repetir.
 * No hay orden
 * La clave y el valor pueden ser de cualquier tipo.
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba13 {
  
  public static void main(String[] args) {
    
    Map rec = new HashMap();
    
    rec.put("C005", 5678);
    rec.put(56789, "Gustavo");
    rec.put(5467.89, "Claudia");
    rec.put("C005", "Chiclayo");
    
    rec.keySet().stream().forEach
        (key -> System.out.println(key + " ==> " +rec.get(key)));
    
  }

}
