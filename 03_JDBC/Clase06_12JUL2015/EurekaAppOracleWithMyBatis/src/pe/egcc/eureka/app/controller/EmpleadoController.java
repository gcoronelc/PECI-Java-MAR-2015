package pe.egcc.eureka.app.controller;

import java.util.List;
import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.EmpleadoService;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class EmpleadoController {

  public List<EmpleadoBean> consultarEmpleados(EmpleadoBean bean) {
    EmpleadoService service = new EmpleadoService();
    return service.getEmpleados(bean);
  }

}
