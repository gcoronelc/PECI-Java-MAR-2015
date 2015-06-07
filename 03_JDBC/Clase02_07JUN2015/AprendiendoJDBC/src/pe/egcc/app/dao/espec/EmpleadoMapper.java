package pe.egcc.app.dao.espec;

import org.apache.ibatis.annotations.Param;
import pe.egcc.app.model.EmpleadoBean;


public interface EmpleadoMapper {

  
  EmpleadoBean getEmpleadoPorUsuario(
      @Param("usuario") String usuario, 
      @Param("clave") String clave);
  
}
