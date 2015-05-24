package pe.egcc.app.util;

import java.util.List;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class AppUtil {

  public static void mostrar(List lista){
    System.out.println("------- LISTA ------");
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i));      
    }
  }
  
}
