package pe.egcc.app.prueba;

import java.util.Arrays;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    int[] notas = {45,76,89,23,65,67,12,59};
    mostrar(notas);
    Arrays.sort(notas);
    mostrar(notas);
    int[] masAltos = Arrays.copyOfRange(notas, notas.length - 3, notas.length);
    mostrar(masAltos);
  }

  private static void mostrar(int[] notas) {
    String data = "";
    for (int n : notas) {
      data += n + " ";
    }
    System.out.println("Arreglo: " + data);
  }
  
}
