// soles a dolares
// dolares a soles
// soles a euros
// euros a soles
// dolares euros
// euros a dolares
package pe.isil.sisaca.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio03Armijos {

  public static void main(String args[]) {
    // soles 
    String tipMoneda1 = "";
    String tipMoneda2 = "";
    double moneda1 = 0.0;
    double moneda2 = 0.0;
    double tipCambiosd = 3.10;
    double tipCambiods = 3.05;
    double tipCambiose = 4.50;
    double tipCambioes = 4.65;
    double tipCambiode = 1.10;
    double tipCambioed = 1.15;
    double result = 0.0;

    tipMoneda1 = Leer1(" 1er tip. Moneda en minuscula ");
    moneda1 = Leer(" 1ra. Monto");
    tipMoneda1 = Leer1(" 2do tip. Moneda en minuscula ");

    if (tipMoneda1.equals("soles") && tipMoneda2.equals("dolares")) {
      result = moneda1 / tipCambiosd;
    } else if (tipMoneda1.equals("dolares") && tipMoneda2.equals("soles")) {
      result = moneda1 / tipCambiods;
    } else if (tipMoneda1.equals("soles") && tipMoneda2.equals("euros")) {
      result = moneda1 / tipCambiose;
    } else if (tipMoneda1.equals("euros") && tipMoneda2.equals("soles")) {
      result = moneda1 / tipCambioes;
    } else if (tipMoneda1.equals("dolares") && tipMoneda2.equals("euros")) {
      result = moneda1 / tipCambiode;
    } else {
      result = moneda1 / tipCambioed;
    }

    System.out.println("cambio de" + tipMoneda1 + " a " + tipMoneda2 + " = " + result);
  }

  private static double Leer(String dato) {
    String texto = JOptionPane.showInputDialog(dato);
    return Double.parseDouble(texto);
  }

  private static String Leer1(String dato) {
    String texto = JOptionPane.showInputDialog(dato);
    return (texto);
  }
}
