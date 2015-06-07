package pe.egcc.eureka.dao.espec;

import java.util.List;

import pe.egcc.eureka.model.ClienteBean;

public interface ClienteMapper {
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

}
