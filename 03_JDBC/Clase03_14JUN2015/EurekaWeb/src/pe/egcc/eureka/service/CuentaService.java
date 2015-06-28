package pe.egcc.eureka.service;

import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.dao.espec.CuentaMapper;

public class CuentaService extends ServiceAbstract {
  
  
  public void registrarRetiro(String cuenta, double importe, String empleado, String clave){
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession();
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

}
