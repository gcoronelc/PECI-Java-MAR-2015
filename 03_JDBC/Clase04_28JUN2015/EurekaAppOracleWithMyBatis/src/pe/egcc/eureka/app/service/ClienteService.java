package pe.egcc.eureka.app.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.app.dao.espec.ClienteMapper;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.model.ComboBean;

public class ClienteService extends AbstractService{

  public List<ClienteBean> getClientes(ClienteBean clienteBean){
    List<ClienteBean> lista = null;
    SqlSession session = sqlSessionFactory.openSession();
    ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
    lista = clienteMapper.getClientes(clienteBean);
    session.close();
    return lista;
  }
  
  public List<ComboBean> getListaDistritos(){
    List<ComboBean> lista = null;
    SqlSession session = sqlSessionFactory.openSession();
    ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
    lista = clienteMapper.getListaDistritos();
    session.close();
    return lista;
  }
  
  public void actualizar(ClienteBean clienteBean){
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession();
      ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
      clienteMapper.actualizar(clienteBean);
      session.commit();
    } catch (Exception e) {
      try {
        session.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        if(session!=null) session.close();
      } catch (Exception e) {
      }
    }
  }
}
