package pe.egcc.eureka.app.dao.espec;

import java.util.List;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.model.ComboBean;


public interface ClienteMapper {
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

  List<ComboBean> getListaDistritos();
  
  void actualizar(ClienteBean clienteBean);
  
  void insertar(ClienteBean clienteBean);
  
  int getCuentas(String codigo);
  
  void eliminar(String codigo);
  
}
