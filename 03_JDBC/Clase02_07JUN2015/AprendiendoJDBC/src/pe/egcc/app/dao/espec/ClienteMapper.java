package pe.egcc.app.dao.espec;

import java.util.List;
import pe.egcc.app.model.ClienteBean;


public interface ClienteMapper {
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

}
