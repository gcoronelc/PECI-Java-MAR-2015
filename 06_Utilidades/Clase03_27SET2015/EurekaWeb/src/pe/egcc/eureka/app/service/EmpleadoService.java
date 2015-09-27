package pe.egcc.eureka.app.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.egcc.eureka.app.dao.espec.EmpleadoMapper;
import pe.egcc.eureka.app.model.EmpleadoBean;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class EmpleadoService extends AbstractService{

  
  public List<EmpleadoBean> getEmpleados(EmpleadoBean empleadoBean){
    List<EmpleadoBean> lista = null;
    SqlSession session = sqlSessionFactory.openSession();
    EmpleadoMapper empleadoMapper = session.getMapper(EmpleadoMapper.class);
    lista = empleadoMapper.getEmpleados(empleadoBean);
    session.close();
    return lista;
  }
}
