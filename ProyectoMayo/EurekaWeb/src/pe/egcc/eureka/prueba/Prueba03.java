package pe.egcc.eureka.prueba;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pe.egcc.eureka.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.dao.espec.CuentaMapper;

public class Prueba03 {

  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    CuentaMapper cuentaMapper = ss.getMapper(CuentaMapper.class);
    cuentaMapper.registrarRetiro("00100001", 200.0, "0003", "123456");
    ss.close();
    System.out.println("FIN");
  }
}
