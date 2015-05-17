package pe.isil.sisaca.prueba;

import pe.isil.sisaca.model.MateModel;

/**
 *
 * @author Profesor
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    
    MateModel model1 = new MateModel();
    model1.autor = "GUSTAVO";
    
    MateModel model2 = model1;
    
    System.out.println("Autor: " + model2.autor);
    System.out.println("Promedio: " + model2.promedio(14, 15, 18));
    
  }
}
