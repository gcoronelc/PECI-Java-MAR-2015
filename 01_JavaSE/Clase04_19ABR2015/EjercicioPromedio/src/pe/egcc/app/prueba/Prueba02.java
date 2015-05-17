package pe.egcc.app.prueba;

import pe.egcc.app.model.Estudiante;
import pe.egcc.app.service.PromedioService;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    for(Estudiante e: PromedioService.traerTodos()){
      System.out.println(e.getNombre() + "   "+ e.getNombre());
    }
  }

}
