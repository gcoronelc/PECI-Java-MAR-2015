package pe.egcc.viaexitos.pagoapp.prueba;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    StringBuilder cadena = new StringBuilder("Gustavo");
    System.out.println(cadena);
    cambiar(cadena);
    System.out.println(cadena);
            
  }

  private static void cambiar(StringBuilder cadena) {
    cadena.replace(0,cadena.length(),"Eric");
  }
}
