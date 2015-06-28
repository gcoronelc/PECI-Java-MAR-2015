package pe.egcc.eureka.app.prueba;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.app.dao.espec.EmpleadoMapper;
import pe.egcc.eureka.app.model.EmpleadoBean;


public class Prueba01 {

  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    EmpleadoMapper empleadoMapper = ss.getMapper(EmpleadoMapper.class);
    EmpleadoBean bean = 
            empleadoMapper.getEmpleadoPorUsuario("lcastro", "suerte");
    ss.close();
    System.out.println("Nombre: " + bean.getNombre());
    System.out.println("Paterno: " + bean.getPaterno());
    System.out.println("Materno: " + bean.getMaterno());
  }
}
