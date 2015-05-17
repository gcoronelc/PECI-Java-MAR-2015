package pe.egcc.prueba;

import pe.egcc.model.Producto;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    
    Producto obj = new Producto();
    
    System.out.println("Nombre: " + obj.getNombre());
    System.out.println("Precio: " + obj.getPrecio());
    System.out.println("Stock: " + obj.getStock());
    
    obj.setPrecio(15.0);
    
    System.out.println("----------------------------");
    System.out.println("Nombre: " + obj.getNombre());
    System.out.println("Precio: " + obj.getPrecio());
    System.out.println("Stock: " + obj.getStock());
    
  }
  
}
