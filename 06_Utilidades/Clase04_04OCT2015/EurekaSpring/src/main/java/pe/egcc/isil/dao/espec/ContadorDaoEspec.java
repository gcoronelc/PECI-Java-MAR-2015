package pe.egcc.isil.dao.espec;

import pe.egcc.isil.model.ContadorBean;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public interface ContadorDaoEspec {
  
  ContadorBean leerDatos(String tabla);
  
  void actualizarDatos(ContadorBean contadorBean);
  
}
