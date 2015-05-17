package pe.egcc.isil.armijos;

import javax.swing.JOptionPane;

public class Ejercicio03 {

  public static void main(String args[]) {
    // Datos
    double promPract = leerDouble("Promedio de practicas");
    double notaParcial = leerDouble("Examen parcial");
    double notaFinal = leerDouble("Examen final");
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
    System.out.println("Promedio Practicas = " + promPract);
    System.out.println("Nota Exam. Pracial = " + notaParcial);
    System.out.println("Nota Exam. final = " + notaFinal);
    System.out.println("Nota Promedio = " + promedio);
    System.out.println("Condición = " + condicion);
    
  }

  private static double leerDouble(String dato) {
    String texto = JOptionPane.showInputDialog(dato);
    return Double.parseDouble(texto);
  }
  
}
