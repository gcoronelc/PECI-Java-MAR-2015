package pe.egcc.eureka.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.dao.espec.ClienteMapper;
import pe.egcc.eureka.model.ClienteBean;

public class ClienteService extends ServiceAbstract{

  public List<ClienteBean> getClientes(ClienteBean clienteBean){
    List<ClienteBean> lista = null;
    SqlSession session = sqlSessionFactory.openSession();
    ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
    lista = clienteMapper.getClientes(clienteBean);
    session.close();
    return lista;
  }
  
}
