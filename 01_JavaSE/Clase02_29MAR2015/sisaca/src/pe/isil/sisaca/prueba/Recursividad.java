package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class Recursividad {

  public static void main(String[] args) {
    int n = 8;
    long f = factorial(5);
    System.out.println("f = " + f);
  }

  /**
   * n! = n * (n-1)!
   * @param n
   * @return 
   */
  private static long factorial(int n) {
    if(n == 0 || n == 1) return 1;
    else return n * factorial(n-1);
  }
}
