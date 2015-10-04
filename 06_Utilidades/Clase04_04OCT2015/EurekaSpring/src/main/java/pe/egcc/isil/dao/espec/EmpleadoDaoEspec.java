package pe.egcc.isil.dao.espec;

import java.util.List;

import pe.egcc.isil.model.EmpleadoBean;



public interface EmpleadoDaoEspec {

  
  EmpleadoBean getEmpleadoPorUsuario(
       String usuario, 
      String clave);
  
  List<EmpleadoBean> getEmpleados(EmpleadoBean empleadoBean);
  
}
