package pe.egcc.eureka.app.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.app.dao.espec.CuentaMapper;

public class CuentaService extends AbstractService {
  
  
  public void registrarRetiro(String cuenta, double importe, String empleado, String clave){
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession(true);
      CuentaMapper cuentaMapper = session.getMapper(CuentaMapper.class);
      cuentaMapper.registrarRetiro(cuenta, importe, empleado, clave);     
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        if(session != null) session.close();
      } catch (Exception e2) {
      }
    }
  }

  public  List<Map<String,Object>> getMovimientos(String cuenta){
    SqlSession session = null;
    List<Map<String,Object>> lista = null;
    try {
      session = sqlSessionFactory.openSession();
      CuentaMapper cuentaMapper = session.getMapper(CuentaMapper.class);
      lista = cuentaMapper.getMovimientos(cuenta);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        if(session != null) session.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }
}
