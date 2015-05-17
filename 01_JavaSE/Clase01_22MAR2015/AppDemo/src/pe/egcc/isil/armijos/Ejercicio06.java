
package pe.egcc.isil.armijos;

//import java.util.Scanner;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class Ejercicio06 {
    public static void main(String args[]){
        // Datos
        double num01 = Leer("1er Número ");
        double num02 = Leer("2do Número ");
        double num03 = Leer("3er Número");   
        double num04 = Leer("4to Número");   
        double num05 = Leer("5to Número");   
        
        // Proceso
        double mayor = mayor(num01, num02, num03, num04, num05);
        
        // Reporte
        System.out.println("1er Número = " + num01);
        System.out.println("2do Número = " + num02);
        System.out.println("3er Número = " + num03);
        System.out.println("4to Número = " + num04);
        System.out.println("5to Número = " + num05);
        System.out.println("Número Mayor = " + mayor);        
        
    }

    private static double Leer(String dato) {
        String texto = JOptionPane.showInputDialog(dato);
        return Double.parseDouble(texto);
    }

  private static double mayor(double ... numeros) {
    Arrays.sort(numeros);
    return numeros[numeros.length - 1];
  }
}
