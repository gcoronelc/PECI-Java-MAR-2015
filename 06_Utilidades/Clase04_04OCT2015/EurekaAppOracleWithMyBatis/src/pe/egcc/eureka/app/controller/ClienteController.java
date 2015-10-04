package pe.egcc.eureka.app.controller;

import java.util.List;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.service.ClienteService;
import pe.egcc.eureka.app.util.EurekaUtil;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class ClienteController {
  
  public List<ClienteBean> consultarClientes(ClienteBean clienteBean){
    ClienteService clienteService = new ClienteService();
    return clienteService.getClientes(clienteBean);
  }

  
  public void procesar(String accion, ClienteBean clienteBean){
    ClienteService clienteService = new ClienteService();
    switch(accion){
      case EurekaUtil.EDICION_EDITAR:
        clienteService.actualizar(clienteBean);
        break;
      case EurekaUtil.EDICION_NUEVO:
        clienteService.insertar(clienteBean);
        break;
      case EurekaUtil.EDICION_ELIMINAR:
        clienteService.eliminar(clienteBean.getCodigo());
        break;
    }
  }
  
}
