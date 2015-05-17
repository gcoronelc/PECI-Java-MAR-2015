package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class Bucle02 {

  public static void main(String[] args) {
    int n = 0;
    int suma = 0;
    while(n < 10){
      suma += ++n;
    }
    System.out.println("Suma: " + suma);
  }
}
