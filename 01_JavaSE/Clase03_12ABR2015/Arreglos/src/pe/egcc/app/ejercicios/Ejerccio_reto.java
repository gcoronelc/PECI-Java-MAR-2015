/*
 * Generar un arreglo de 20 elementos con datos numéricos entre 50 y 100
 * Luego encontrar el mayor , el menor, el promedio, la mediana
 */
package pe.egcc.app.ejercicios;

import java.util.Arrays;
import java.util.Random;

public class Ejerccio_reto {

  public static void main(String[] args) {
    Random rnd = new Random();
    int num[] = new int[19];
    for (int i = 0; i <= num.length - 1; i++) {
      num[i] = rnd.nextInt(50) + 50;
      System.out.println((i + 1) + " Número : " + num[i]);
    }
    Arrays.sort(num);
    int[] menor = Arrays.copyOfRange(num, 0, 1);
    System.out.println(" -----------------");
    System.out.println(" Menor : " + menor[0]);
    int[] mayor = Arrays.copyOfRange(num, num.length - 1, num.length);
    System.out.println(" -----------------");
    System.out.println(" Mayor : " + mayor[0]);
    System.out.println(" -----------------");
    mostrarPromedio(num);
    System.out.println(" -----------------");
    mostrarMediana(num);
  }

  private static void mostrarPromedio(int[] num) {
    double promedio = 0;
    for (int i = 0; i <= num.length - 1; i++) {
      promedio = num[i] + promedio;
    }
    promedio = promedio / num.length;
    //System.out.println(" length : " + num.length); 
    System.out.println(" Promedio : " + promedio);
  }

  private static void mostrarMediana(int[] num) {
    double mediana = 0;
    int medianaPos = 0;
    if (num.length % 2 == 0) {
      for (int i = 0; i <= num.length - 1; i++) {
        mediana = num[i] + mediana;
      }
      mediana = mediana / num.length;
      System.out.println(" Mediana : " + mediana);
    } else {
      medianaPos = num.length / 2;
      System.out.println(" Mediana : " + num[medianaPos]);
    }

  }
}
