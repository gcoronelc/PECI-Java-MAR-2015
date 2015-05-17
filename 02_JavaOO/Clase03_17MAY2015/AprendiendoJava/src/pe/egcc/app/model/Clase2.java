package pe.egcc.app.model;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Clase2 extends Clase1 {

  public Clase2() {
    super("CLAUDIA");
    System.out.println("Hola Gustavo");
  }

  @Override
  public int sumar(int n1, int n2) {
    int s = (n1 + n2) * (n1 - n2);
    return s;
  }

  public int restar(int n1, int n2) {
    return (n1 - n2);
  }

}
