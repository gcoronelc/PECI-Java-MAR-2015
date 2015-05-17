package pe.egcc.isil.armijos;

import java.util.Scanner;

public class Ejercicio02 {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // Datos
    System.out.print("Promedio de practicas: ");
    double promPract = sc.nextDouble();
    System.out.print("Ingrese Exam. Pracial: ");
    double notaParcial = sc.nextDouble();
    System.out.print("Ingrese Exam. final: ");
    double notaFinal = sc.nextDouble();
    // Proceso
    double promedio = 0.00;
    promedio = (promPract * 0.4) + (notaParcial * 0.2) + (notaFinal * 0.4);
    String condicion;
    if (promedio >= 14) {
      condicion = "Aprobado";
    } else {
      condicion = "Desaprobado";
    }
    // Reporte
    System.out.println("Nota Exam. Pracial = " + notaParcial);
    System.out.println("Promedio Practicas = " + promPract);
    System.out.println("Nota Exam. final = " + notaFinal);
    System.out.println("Nota Promedio = " + promedio);
    System.out.println("Condición = " + condicion);
    
  }
}
