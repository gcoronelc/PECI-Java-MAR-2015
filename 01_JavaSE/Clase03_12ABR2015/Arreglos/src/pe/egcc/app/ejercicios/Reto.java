package pe.egcc.app.ejercicios;

import java.util.Arrays;

/**
 *
 * @author Asamue alegria
 *
 */
public class Reto {

  public static void main(String[] args) {

    int[] numeros = new int[20];
    for (int i = 0; i < 20; i++) {
      int nu = (int) (Math.random() * 100 + 1);
      if (nu > 49) {
        numeros[i] = nu;
      } else {
        i--;
      }
    }

    Arrays.sort(numeros);
    mostrar(numeros);
    int numeromenor = numeros[0];
    int numeroalto = numeros[numeros.length - 1];
    
    System.out.println("el numero mayor del arreglo es: " + numeroalto);    
    System.out.println("el numero menor del areglo es: " + numeromenor);
    
    promedio(numeros);
    mediana(numeros);
  }

  private static void mostrar(int[] numeros) {
    String datos = " ";
    for (int i : numeros) {
      datos += i + " ";
    }
    System.out.println(datos);
  }

  private static void promedio(int[] numeros) {
    int sumatoria = 0;
    for (int i : numeros) {
      sumatoria += i;
    }
    double promedio = sumatoria / (numeros.length);
    System.out.println(promedio);
  }

  private static void mediana(int[] numeros) {
    int posicion, medio;
    posicion = numeros.length;
    if (posicion % 2 == 0) {
      System.out.println("no tiene mediana");
    } else {
      posicion = (posicion / 2) + 1 / 2;
      posicion = numeros[posicion];
      System.out.println("el numero medio del arreglo es" + posicion);
    }
  }

}
