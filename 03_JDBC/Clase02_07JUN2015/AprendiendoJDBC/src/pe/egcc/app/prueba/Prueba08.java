package pe.egcc.app.prueba;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.app.dao.MyBatisConnectionFactory;
import pe.egcc.app.dao.espec.EmpleadoMapper;
import pe.egcc.app.model.EmpleadoBean;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba08 {

  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession session = ssf.openSession();
    EmpleadoMapper empleadoMapper = session.getMapper(EmpleadoMapper.class);
    EmpleadoBean bean = empleadoMapper.getEmpleadoPorUsuario("lcastro", "suerte");
    session.close();
    System.out.println("Nombre: " + bean.getNombre());
    System.out.println("Paterno: " + bean.getPaterno());
  }
  
}
