package pe.egcc.isil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.isil.dao.espec.CuentaDaoEspec;

@Service
public class CuentaService {

  @Autowired
  private CuentaDaoEspec cuentaDao;
  
  public List<Map<String, Object>> getMovimientos(String cuenta) {
    return cuentaDao.getMovimientos(cuenta);
  }
}
