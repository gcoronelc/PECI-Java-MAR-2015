/*
 * Desarrollar un programa para encontrar el mayor de tres numeros.
 */

package pe.egcc.isil.aching;

import javax.swing.JOptionPane;

/**
 *
 * @author Alumno-CT
 */
public class Ejercicio003 {
    public static void main(String[] args) {
      
        // Ingreso de Datos
        double Numero1 = leer("Ingrese Primer Numero: ");
        double Numero2 = leer("Ingrese Segundo Numero: ");
        double Numero3 = leer("Ingrese Tercer Numero: ");
        double Numero4 = leer("Ingrese Cuarto Numero: ");
        
        //Proceso
        if(Numero1 > Numero2 && Numero1 > Numero3 && Numero1 > Numero4)
            System.out.println("El Numero mayor es: " +Numero1);
        else if(Numero2 > Numero1 && Numero2 > Numero3 && Numero2 > Numero4)
            System.out.println("El Numero mayor es: " +Numero2);
        else if (Numero3 > Numero1 && Numero3 > Numero2 && Numero3 > Numero4)
            System.out.println("El Numero mayor es: " +Numero3);
        else if (Numero4 > Numero1 && Numero4 > Numero2 && Numero4 > Numero3)
            System.out.println("El Numero mayor es: " +Numero4);
    }

    private static double leer(String numero) {
        String txt = JOptionPane.showInputDialog(numero);
        return Double.parseDouble(txt);
    }
    
}
