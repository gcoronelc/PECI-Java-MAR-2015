package pe.egcc.app.prueba;

import pe.egcc.app.espec.IMate;
import pe.egcc.app.model.MateImpl1;
import pe.egcc.app.model.MateImpl2;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    IMate mate = new MateImpl2();
    System.out.println("7 + 5 = " + mate.sumar(7, 5));
  }
}
