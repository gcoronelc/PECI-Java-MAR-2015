package pe.egcc.app.prueba;

import java.util.Random;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba11 {

  public static void main(String[] args) {
    int[][] mat1 = {
      {67,43,12,65,78,23},
      {34,65,67,21},
      {23,43,67,34,54}
    };
    System.out.println("-------------");
    mostrar(mat1);
  }

  private static void llenar(int[][] mat) {
    Random rnd = new Random();
    for (int i = 0; i < mat.length; i++) {
      int[] fila = mat[i];
      for (int j = 0; j < fila.length; j++) {
        fila[j] = rnd.nextInt(90) + 10;
      }
    }
  }

  private static void mostrar(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      int[] fila = mat[i];
      String sFila = "";
      for (int num : fila) {
        sFila += num + " ";
      }
      System.out.println(sFila);
    }
  }
}
