package pe.egcc.app.prueba;

import pe.egcc.app.model.Mate;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    Mate mate = new Mate();
    System.out.println("7 y 8: " + mate.promdiar(7, 8));
    System.out.println("7 y 8: " + mate.promdiar(7.0, 8));
  }
}
