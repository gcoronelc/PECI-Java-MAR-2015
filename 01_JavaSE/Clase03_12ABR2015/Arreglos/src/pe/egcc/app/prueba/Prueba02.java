package pe.egcc.app.prueba;

import java.util.Arrays;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba02 {
  
  static int lista1[];
  
  public static void main(String[] args) {
    int[] lista2;
    
    lista2 = new int[5];
    
    System.out.println(lista1);
    System.out.println(lista2);
    
    // Recorrido clasico
    for (int i = 0; i < lista2.length; i++) {
      System.out.println(lista2[i]);
    }
    
    lista2[2] = 50;
    // Recorrido tipo for each
    System.out.println("----------------------------");
    for (int n: lista2) {
      System.out.println(n);
    }
    
    // Recorrido tipo Java 8
    System.out.println("------------------------------");
    Arrays.stream(lista2).forEach(n -> System.out.println(n));
  }
  
}
