package pe.egcc.eureka.app.prueba;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.app.dao.espec.CuentaMapper;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba06 {

  public static void main(String[] args) {

    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    CuentaMapper cuentaMapper = ss.getMapper(CuentaMapper.class);
    List<Map<String,Object>> lista = cuentaMapper.getResumen("002", "01");
    for (Map<String, Object> r : lista) {
      System.out.println(r.get("ACCION") + "  " + r.get("IMPORTE") );
    }
    ss.close();
    System.out.println("FIN");

  }

}
