package pe.egcc.eureka.app.controller;

import java.util.List;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.service.ClienteService;

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

}
