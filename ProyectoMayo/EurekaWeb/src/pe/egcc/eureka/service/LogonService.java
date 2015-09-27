package pe.egcc.eureka.service;

import org.apache.ibatis.session.SqlSession;

import pe.egcc.eureka.dao.espec.EmpleadoMapper;
import pe.egcc.eureka.model.EmpleadoBean;

public class LogonService extends ServiceAbstract{
  
  public EmpleadoBean verificarUsuario(String usuario, String clave){
    EmpleadoBean bean = null;
    SqlSession session = null;
    try {
      session = sqlSessionFactory.openSession();
      EmpleadoMapper mapper = session.getMapper(EmpleadoMapper.class);
      bean = mapper.getEmpleadoPorUsuario(usuario, clave);
      if(bean == null){
        throw new RuntimeException("Datos del usuario incorrectos.");
      }
    } catch (RuntimeException e) {
      throw new RuntimeException(e.getMessage());
    }catch (Exception e) {
      throw new RuntimeException("Error de acceso al sistema.");
    } finally{
      try {
        if(session !=null) session.close();
      } catch (Exception e2) {
      }
    }
    return bean;
  }

}
