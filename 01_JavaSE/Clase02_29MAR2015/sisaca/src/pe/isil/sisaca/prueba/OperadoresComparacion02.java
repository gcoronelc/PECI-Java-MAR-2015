package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadoresComparacion02 {

  public static void main(String[] args) {
    
    Long a = 5L;
    Long b = 5L;
    
    boolean igual = (a.longValue() == b.longValue());
    
    System.out.println("Igual: " + igual);
  }
}
