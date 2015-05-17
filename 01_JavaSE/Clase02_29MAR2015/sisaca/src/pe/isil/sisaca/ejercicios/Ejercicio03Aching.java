/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.sisaca.ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author Alumno-CT
 */
public class Ejercicio03Aching {

  public static void main(String[] args) {
    double monto = leerMonto("Ingrese Monto: ");
    double tipoCambioDol = 3.091;
    double tipoCambioEu = 3.453;
    double tipoCambioEuXDol = 1.089;
    double resultado;
    Integer convertir = leer("Convertir: "
            + "\nDe Soles a Dolares     (1)"
            + "\nDe Dolares a Soles     (2)"
            + "\nDe Soles a Euros       (3)"
            + "\nDe Euros a Soles       (4)"
            + "\nDe Dolares a Euros     (5)"
            + "\nDe Euros a Dolares     (6)");

    switch (convertir) {
      case 1:
        resultado = monto / tipoCambioDol;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      case 2:
        resultado = monto * tipoCambioDol;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      case 3:
        resultado = monto / tipoCambioEu;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      case 4:
        resultado = monto * tipoCambioEu;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      case 5:
        resultado = monto / tipoCambioEuXDol;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      case 6:
        resultado = monto * tipoCambioEuXDol;
        System.out.println("Tipo de Cambio es: " + resultado);
        break;
      default:
        System.out.println("ERROR: Opcion Ingresada no es Valida");
        break;
    }

  }

  private static double leerMonto(String dato) {
    String texto = JOptionPane.showInputDialog(dato);
    return Double.parseDouble(texto);
  }

  private static Integer leer(String dato) {
    String texto = JOptionPane.showInputDialog(dato);
    return Integer.parseInt(texto);
  }

}
