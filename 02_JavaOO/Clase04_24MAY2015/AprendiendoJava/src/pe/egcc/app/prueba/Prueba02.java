package pe.egcc.app.prueba;

import pe.egcc.app.model.Clase1;
import pe.egcc.app.model.Clase2;
import pe.egcc.app.model.Clase3;
import pe.egcc.app.model.Clase4;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba02 {

  public static void main(String[] args) {
    
    Clase2 var1 = new Clase2();
    
    if(var1 instanceof Object){
      System.out.println("Compatible con Object");
    }
    
    if(var1 instanceof Clase1){
      System.out.println("Compatible con Clase1");
    }

    if(var1 instanceof Clase2){
      System.out.println("Compatible con Clase2");
    }
    
    if(var1 instanceof Clase3){
      System.out.println("Compatible con Clase3");
    }
    
    if(var1 instanceof Clase4){
      System.out.println("Compatible con Clase4");
    }
    
  }
  
}
