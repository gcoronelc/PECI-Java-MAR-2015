package pe.egcc.isil.dao.espec;

import java.util.List;
import java.util.Map;

public interface CuentaDaoEspec {

  List<Map<String, Object>> getMovimientos(String cuenta);
/*
  void registrarRetiro(String cuenta, Double importe, String empleado, String clave);

  List<Map<String, Object>> getResumen(String sucursal, String moneda);
*/
}
