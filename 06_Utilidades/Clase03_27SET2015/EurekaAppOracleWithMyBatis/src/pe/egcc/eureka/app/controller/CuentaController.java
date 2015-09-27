package pe.egcc.eureka.app.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eureka.app.model.EmpleadoBean;
import pe.egcc.eureka.app.service.CuentaService;
import pe.egcc.eureka.app.util.EurekaUtil;
import pe.egcc.eureka.app.util.Session;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class CuentaController {

  public void registrarRetiro(String cuenta, String clave, double importe){
    // Obtener empleado
    EmpleadoBean bean = (EmpleadoBean) Session.get("usuario");
    // Proceso
    CuentaService cuentaService = new CuentaService();
    cuentaService.registrarRetiro(cuenta, importe, bean.getCodigo(), clave);
  }
  
  public List<Map<String,Object>> getResumen(String sucursal, String moneda){
    CuentaService cuentaService;
    cuentaService = new CuentaService();
    return cuentaService.getResumen(sucursal, moneda);
  } 
  
}
