package pe.egcc.app.prueba;

import pe.egcc.app.util.Isil;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    
    System.out.println(Isil.isInt("123"));
    System.out.println(Isil.isInt("0789"));
    System.out.println(Isil.isInt("N123"));
    System.out.println(Isil.isInt("0xDEAF"));
    
    System.out.println(Integer.parseInt("123"));
    System.out.println(Integer.parseInt("0789"));
    
    int n1 = 123;
    int n2 = 0753;
    int n3 = 0xDEAF;
    
    System.out.println(n1);
    System.out.println(n2);
    System.out.println(n3);
  }
  
}
