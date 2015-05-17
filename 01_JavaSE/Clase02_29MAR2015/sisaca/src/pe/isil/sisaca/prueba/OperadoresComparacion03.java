package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadoresComparacion03 {

  public static void main(String[] args) {
    
    String a = "Gustavo";
    String b = "GUSTAVO";
    
    boolean igual1 = ( a == b );
    boolean igual2 = ( a.equals(b) );
    boolean igual3 = ( a.equalsIgnoreCase(b) );
    
    System.out.println("Igual 1: " + igual1);
    System.out.println("Igual 2: " + igual2);
    System.out.println("Igual 3: " + igual3);
  }
}
