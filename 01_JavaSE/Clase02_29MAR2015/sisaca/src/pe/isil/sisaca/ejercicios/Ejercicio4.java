package pe.isil.sisaca.ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author Alumno-CT
 */
public class Ejercicio4 {

  public static void main(String[] args) {

    int cantidad = Integer.parseInt(Datos("ingrese cantidad"));;
    cantidad = cantidad * 15;

    for (int i = 1; i <= cantidad; i++) {
      if (i % 15 == 0) {
        System.out.println(i);
      }
    }
  }

  private static String Datos(String Dato) {
    String text = JOptionPane.showInputDialog(Dato);
    return text;
  }

}
