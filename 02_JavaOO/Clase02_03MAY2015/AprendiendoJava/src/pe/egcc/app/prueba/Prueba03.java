package pe.egcc.app.prueba;

import pe.egcc.app.domain.Persona;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    Persona p = new Persona();
    System.out.println(p);
    p = new Persona("CLAUDIA", "956-578-876");
    System.err.println(p);
  }

}
