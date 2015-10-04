package pe.egcc.isil.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.isil.dao.espec.EmpleadoDaoEspec;
import pe.egcc.isil.model.EmpleadoBean;

@Service
public class LogonService {
  
  private static final Logger logger = LoggerFactory.getLogger(LogonService.class);
  
  @Autowired
  private EmpleadoDaoEspec empleadoDao;
  
  public EmpleadoBean validar(String usuario, String clave){
    logger.info("EGCC: Inicio de validacion.");
    EmpleadoBean empleadoBean;
    try {
      empleadoBean = empleadoDao.getEmpleadoPorUsuario(usuario, clave);
      logger.info("EGCC: validación correcta.");
    } catch (Exception e) {
      logger.info("EGCC: no se pudo validar la cuenta.");
      empleadoBean = null;
    }
    return empleadoBean;
  }

}
