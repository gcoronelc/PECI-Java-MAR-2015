package pe.isil.sisaca.prueba;

/**
 *
 * @author Profesor
 */
public class OperadoresLogicos {

  public static void main(String[] args) {
    
    Integer a = 10;
    Integer b = null;
    
    boolean c = (a != null & b != null) && (a < b);
    
    System.out.println("c = " + c);
    
  }
}
