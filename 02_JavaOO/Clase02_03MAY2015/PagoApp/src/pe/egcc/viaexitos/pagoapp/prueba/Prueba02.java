package pe.egcc.viaexitos.pagoapp.prueba;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba02 {

  public static void main(String[] args) {
    String cadena = new String("Gustavo");
    System.out.println(cadena);
    cambiar(cadena);
    System.out.println(cadena);
            
  }

  private static void cambiar(String cadena) {
    cadena = cadena.replace('s', 'z');
  }
}
