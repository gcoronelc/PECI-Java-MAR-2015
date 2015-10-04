package pe.egcc.isil.dao.espec;

import java.util.List;

import pe.egcc.isil.model.ClienteBean;
import pe.egcc.isil.model.ComboBean;



public interface ClienteDaoEspec {
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

  /*
  List<ComboBean> getListaDistritos();
  
  void actualizar(ClienteBean clienteBean);
  
  void insertar(ClienteBean clienteBean);
  
  int getCuentas(String codigo);
  
  void eliminar(String codigo);

  ClienteBean getCliente(String codigo);
  */
}
