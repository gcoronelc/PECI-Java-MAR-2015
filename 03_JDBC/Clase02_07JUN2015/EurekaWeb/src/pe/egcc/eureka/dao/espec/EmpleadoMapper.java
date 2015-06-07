package pe.egcc.eureka.dao.espec;

import org.apache.ibatis.annotations.Param;

import pe.egcc.eureka.model.EmpleadoBean;

public interface EmpleadoMapper {

  
  EmpleadoBean getEmpleadoPorUsuario(
      @Param("usuario") String usuario, 
      @Param("clave") String clave);
  
}
