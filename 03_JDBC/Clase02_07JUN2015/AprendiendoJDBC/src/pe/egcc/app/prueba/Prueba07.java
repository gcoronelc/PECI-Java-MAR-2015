package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.util.JdbcUtil;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba07 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "with v1 as ( "
              + "	select "
              + "	  chr_tipocodigo tipo, "
              + "	  count(*) cantidad, "
              + "	  sum(dec_moviimporte) importe "
              + "	from movimiento "
              + "	group by chr_tipocodigo) "
              + "select  "
              + "	v1.tipo, "
              + "	tm.vch_tipodescripcion detipo, "
              + "	v1.cantidad, "
              + "	v1.importe "
              + "from v1 "
              + "join tipomovimiento tm "
              + "on v1.tipo = tm.chr_tipocodigo";
      PreparedStatement ps = cn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      List<Map<String,?>> lista = JdbcUtil.rsToList(rs);
      rs.close();
      ps.close();
      for (Map<String, ?> r : lista) {
        System.out.println(r.get("tipo") + "   " +
                r.get("detipo") + "\t" + 
                r.get("cantidad") + "\t" + 
                r.get("importe"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (cn != null) {
          cn.close();
        }
      } catch (Exception e) {
      }
    }
  }

}
