package pe.egcc.app.prueba;

import pe.egcc.app.model.Estudiante;
import pe.egcc.app.service.PromedioService;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    Estudiante bean = new Estudiante("MARLENE", 11, 12, 10, 11, 11);
    PromedioService.grabar(bean);
    System.out.println("Ok.");
  }
}
