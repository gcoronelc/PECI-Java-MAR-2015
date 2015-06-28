package pe.egcc.eureka.dao.espec;

import java.util.List;

import pe.egcc.eureka.model.ClienteBean;
import pe.egcc.eureka.model.ComboBean;

public interface ClienteMapper {
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

  List<ComboBean> getListaDistritos();
  
}
