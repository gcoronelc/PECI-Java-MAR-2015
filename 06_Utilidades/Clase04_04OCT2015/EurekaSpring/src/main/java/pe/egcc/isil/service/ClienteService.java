package pe.egcc.isil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.isil.dao.espec.ClienteDaoEspec;
import pe.egcc.isil.model.ClienteBean;

@Service
public class ClienteService {

  @Autowired
  private ClienteDaoEspec clienteDao;
  
  public List<ClienteBean> getClientes(ClienteBean clienteBean){
    clienteBean.establecerDatos();
    return clienteDao.getClientes(clienteBean);
  }
}
