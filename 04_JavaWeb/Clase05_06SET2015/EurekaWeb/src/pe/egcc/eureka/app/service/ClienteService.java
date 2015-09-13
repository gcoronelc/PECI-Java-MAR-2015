package pe.egcc.eureka.app.service;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.app.dao.espec.ClienteMapper;
import pe.egcc.eureka.app.dao.espec.ContadorMapper;
import pe.egcc.eureka.app.model.ClienteBean;
import pe.egcc.eureka.app.model.ComboBean;
import pe.egcc.eureka.app.model.ContadorBean;

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
  
  public void insertar(ClienteBean clienteBean){
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession();
      ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
      ContadorMapper contadorMapper = session.getMapper(ContadorMapper.class);
      // Leer datos del contador
      ContadorBean contadorBean = contadorMapper.leerDatos("Cliente");
      contadorBean.setContador(contadorBean.getContador() + 1);
      contadorMapper.actualizarDatos(contadorBean);
      // Generar el codigo
      String patron = "";
      for (int i = 1; i <= contadorBean.getLongitud(); i++) {
        patron += "0";        
      }
      DecimalFormat decimalFormat = new DecimalFormat(patron);
      String codigo = decimalFormat.format(contadorBean.getContador());
      // Grabar el nuevo cliente
      clienteBean.setCodigo(codigo);
      clienteMapper.insertar(clienteBean);
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
  
  public void eliminar(String codigo){
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession();
      ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
      // Averiguar si tiene cuentas
      int cuentas = clienteMapper.getCuentas(codigo);
      if(cuentas > 0){
        throw new RuntimeException("Cliente tiene cuentas, no se puede eliminar.");
      }
      // Eliminar cliente
      clienteMapper.eliminar(codigo);
      // Confirmar Tx
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
