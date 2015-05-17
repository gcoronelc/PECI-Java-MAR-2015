package pe.isil.sisaca.ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author Alumno-CT
 */
public class Ejercicio2 {

  public static void main(String[] args) {

    //datos
    String mes = llenar("ingresar el mes");
    int aaa = Integer.parseInt(llenar("ingresar el año"));

    //variables
    int diasqueTieneunMes = 0;
    int mesdeFebrero;

    //proceso
    diasqueTieneunMes = (mes.equals("enero")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (aaa % 4 == 0 || mes.equals("febrero")) ? 29 : 28;
    diasqueTieneunMes = (mes.equals("marzo")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("abril")) ? 30 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("mayo")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("junio")) ? 30 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("julio")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("agosto")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("setiembre")) ? 30 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("octubre")) ? 31 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("noviembre")) ? 30 : diasqueTieneunMes;
    diasqueTieneunMes = (mes.equals("diciembre")) ? 31 : diasqueTieneunMes;

    System.out.println(" el mes  de " + mes + "tiene " + diasqueTieneunMes + "dias");

  }

  private static String llenar(String dato) {
    String tex = JOptionPane.showInputDialog(dato);
    return tex;
  }

}
