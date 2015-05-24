package pe.egcc.app.prueba;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.app.model.Clase1;
import pe.egcc.app.util.AppUtil;

/**
 * Lista generica.
 * Los elementos pueden ser de cualquier tipo.
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba08 {

  public static void main(String[] args) {
    
    List lista = new ArrayList();
    
    lista.add(345);
    lista.add(456.78);
    lista.add("Java");
    lista.add(new Clase1());
    AppUtil.mostrar(lista);
    
    lista.add(1, "Gustavo");
    AppUtil.mostrar(lista);
    
    lista.set(1, "Claudia");
    AppUtil.mostrar(lista);
    
    lista.remove(1);
    AppUtil.mostrar(lista);
    
    // Recorrido tipo for each
    System.out.println("-------------------");
    System.out.println("Lista generica");
    for (Object object : lista) {
      System.out.println(object);
    }
    
    // Recorrido tipo lambda
    System.out.println("----------------------------");
    lista.stream().forEach(o -> System.out.println(o) );
  }
}
