package pe.egcc.app.model;

import pe.egcc.app.espec.IMate;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class MateImpl2 implements IMate {

  @Override
  public int sumar(int n1, int n2) {
    return (n1 + n2) * (n1 - n2);
  }

}
