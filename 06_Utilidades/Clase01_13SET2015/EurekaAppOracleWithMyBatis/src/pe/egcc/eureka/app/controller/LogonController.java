package pe.egcc.eureka.app.controller;

import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.LogonService;
import pe.egcc.eureka.app.util.Session;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class LogonController {
  
  
  public void validar(String usuario, String clave){
    LogonService logonService = new LogonService();
    EmpleadoBean bean = logonService.verificarUsuario(usuario, clave);
    Session.put("usuario", bean);
  }

}
