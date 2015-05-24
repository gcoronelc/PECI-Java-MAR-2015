package pe.egcc.app.model;

import pe.egcc.app.espec.IDemo;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Clase1 implements IDemo{

  public Clase1() {
    System.out.println("HOLA JAVA.");
  }

  public Clase1(String nombre) {
    System.out.println("HOLA " + nombre);
  }

  public int sumar(int n1, int n2) {
    return (n1 + n2);
  }

  @Override
  public int promediar(int n1, int n2) {
    return sumar(n1, n2) / 2;
  }

}
