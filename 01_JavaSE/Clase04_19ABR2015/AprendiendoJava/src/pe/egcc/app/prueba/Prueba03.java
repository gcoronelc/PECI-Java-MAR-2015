package pe.egcc.app.prueba;

import java.util.regex.Pattern;
import pe.egcc.app.util.Isil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    // boolean b = Pattern.matches("[0-9]+", "1234");
    String cad = "123467777777777777";
    boolean b = Isil.sonDigitos(cad);
    System.out.println(b);
    int n = Integer.parseInt(cad);
    System.out.println(cad);
  }

}
