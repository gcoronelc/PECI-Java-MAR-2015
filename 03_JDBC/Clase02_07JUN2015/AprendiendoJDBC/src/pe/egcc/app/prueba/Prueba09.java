package pe.egcc.app.prueba;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.egcc.app.dao.MyBatisConnectionFactory;
import pe.egcc.app.dao.espec.ClienteMapper;
import pe.egcc.app.dao.espec.EmpleadoMapper;
import pe.egcc.app.model.ClienteBean;
import pe.egcc.app.model.EmpleadoBean;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba09 {
  public static void main(String[] args) {
    SqlSessionFactory ssf = MyBatisConnectionFactory.getSqlSessionFactory();
    SqlSession session = ssf.openSession();
    ClienteMapper clienteMapper = session.getMapper(ClienteMapper.class);
    ClienteBean clienteBean = new ClienteBean();
    //clienteBean.setPaterno("CO");
    //clienteBean.setNombre("E");
    clienteBean.setEmail("gmail");
    clienteBean.establecerDatos();
    List<ClienteBean> lista = clienteMapper.getClientes(clienteBean);
    session.close();
    for (ClienteBean r : lista) {
      System.out.println(r.getCodigo() + " " +
              r.getPaterno() + "\t" + 
              r.getMaterno() + "\t" + 
              r.getNombre());
    }
  }

}
