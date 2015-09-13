package pe.egcc.eureka.app.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.app.dao.espec.CuentaMapper;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba05 {

  public static void main(String[] args) {

    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    CuentaMapper cuentaMapper = ss.getMapper(CuentaMapper.class);
    List<Map<String,Object>> lista = cuentaMapper.getMovimientos("00100002");
    for (Map<String, Object> r : lista) {
      System.out.println(r.get("NROMOV") + "  " + r.get("TIPO") + "   " + r.get("IMPORTE") );
    }
    ss.close();
    System.out.println("FIN");

  }

}
