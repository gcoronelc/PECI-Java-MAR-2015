package pe.egcc.eureka.app.dao.espec;

import pe.egcc.eureka.app.model.ContadorBean;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public interface ContadorMapper {
  
  ContadorBean leerDatos(String tabla);
  
  void actualizarDatos(ContadorBean contadorBean);
  
}
