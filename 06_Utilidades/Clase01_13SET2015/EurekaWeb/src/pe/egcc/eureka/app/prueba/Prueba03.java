package pe.egcc.eureka.app.prueba;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.app.dao.espec.CuentaMapper;


public class Prueba03 {

  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    CuentaMapper cuentaMapper = ss.getMapper(CuentaMapper.class);
    cuentaMapper.registrarRetiro("00200002", 50.0, "0003", "123456");
    ss.close();
    System.out.println("FIN");
  }
}
