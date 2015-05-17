package pe.isil.sisaca.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio01 {

  public static void main(String[] args) {
    //datos
    Double pagoPorHora = Double.parseDouble(llenar("ingrese el pago por hora"));
    Double horasPorDia = Double.parseDouble(llenar("ingrese las horas por dia"));
    Double diasTrabajados = Double.parseDouble(llenar("ingrese dias trabajados"));
    //variables
    Double ingreso = 0.0, renta = 0.0, neto = 0.0;
    //procesos
    ingreso = pagoPorHora * horasPorDia * diasTrabajados;
    /*if (ingreso >= 1500) {
      renta = ingreso * 0.1;
    }*/
    renta = (ingreso>=1500.0)?ingreso*0.10:0.0;
    neto = ingreso - renta;

    System.out.println("el ingreso es " + ingreso);
    System.out.println("la renta es " + renta);
    System.out.println("neto " + neto);
  }

  private static String llenar(String dato) {
    String text = JOptionPane.showInputDialog(dato);
    return text;
  }
}
