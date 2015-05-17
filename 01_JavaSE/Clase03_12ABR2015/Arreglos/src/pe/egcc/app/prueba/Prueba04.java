package pe.egcc.app.prueba;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba04 {

  public static void main(String[] args) {
    
    String lista1[] = {"Chiclayo", "Cuzco", "Arequipa", "Huancayo", "Trujillo", "Tacna"};
    String lista2[];
    lista2 = new String[]{"Iquitos","Piura","Lima","Ica"};
    
    String[] lista3 = juntar(lista1, lista2);
    mostrar(lista3);
    
    // Ordenado en forma ascendente
    Arrays.sort(lista3);
    System.out.println("------------ Ordenada ------------");
    mostrar(lista3);
  }

  private static String[] juntar(String[] lista1, String[] lista2) {
    String[] lista3;
    lista3 = new String[lista1.length + lista2.length];
    System.arraycopy(lista1, 0, lista3, 0, lista1.length);
    System.arraycopy(lista2, 0, lista3, lista1.length, lista2.length);
    return lista3;
  }

  private static void mostrar(String[] lista3) {
    for (String dato : lista3) {
      System.out.println(dato);
    }
  }
}
