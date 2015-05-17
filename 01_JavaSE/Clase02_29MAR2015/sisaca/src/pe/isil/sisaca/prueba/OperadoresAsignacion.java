package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadoresAsignacion {

  public static void main(String[] args) {
    int n;
    n = 5;
    System.out.println("n = " + n);
    n = n * n - n;
    System.out.println("n = " + n);
    n = Math.multiplyExact(n, n);
    System.out.println("n = " + n);
    
    n += 5; // n = n + 5
    System.out.println("n = " + n);
    
    n -= 50; // n = n - 50
    System.out.println("n = " + n);
    
    n--; // Disminuye en uno el valor de n
    --n; // Disminuye en uno el valor de n, mayor prioridad
    System.out.println("n = " + n--);
    System.out.println("n = " + --n);
  }
  
}
