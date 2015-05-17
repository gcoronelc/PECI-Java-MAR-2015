package pe.egcc.app.prueba;

import java.util.regex.Pattern;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba04 {

  public static void main(String[] args) {
    boolean b = Pattern.matches("[0-9]{4,6}", "8888888");
    System.out.println(b);
  }

}
