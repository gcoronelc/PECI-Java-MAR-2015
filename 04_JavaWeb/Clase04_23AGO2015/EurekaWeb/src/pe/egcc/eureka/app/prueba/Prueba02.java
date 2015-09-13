package pe.egcc.eureka.app.prueba;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;
import pe.egcc.eureka.app.dao.espec.ClienteMapper;
import pe.egcc.eureka.app.model.ClienteBean;


public class Prueba02 {

  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession ss = ssf.openSession();
    ClienteMapper clienteMapper = ss.getMapper(ClienteMapper.class);
    ClienteBean bean = new ClienteBean();
    //bean.setPaterno("C");
    bean.setNombre("E");
    //bean.setDireccion("LOS OLIVOS");
    bean.setEmail("@gmail");
    bean.establecerDatos();
    List<ClienteBean> lista = clienteMapper.getClientes(bean);
    ss.close();
    for(ClienteBean b: lista){
      System.out.println(b.getNombre() + "-" + b.getPaterno() + "-" + b.getMaterno());
    }
    System.out.println("FIN");
  }
}
