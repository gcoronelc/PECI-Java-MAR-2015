package pe.egcc.app.prueba;

import pe.egcc.app.espec.IDemo;
import pe.egcc.app.model.Clase1;
import pe.egcc.app.model.Clase2;
import pe.egcc.app.model.Clase3;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba07 {
  
  public static void main(String[] args) {
    Clase1 o1 = new Clase2();
    System.out.println("7 + 5 = " + o1.sumar(7, 5));
    IDemo o2 = o1;
    System.out.println("7 y 5 = " + o2.promediar(7, 5));
    Clase2 o3 = (Clase2) o1;
    if(o1 instanceof Clase3){
      Clase3 o4 = (Clase3) o1;
      System.out.println("7 y 5 = " + o4.promediar(7, 5));
    }
  }

}
