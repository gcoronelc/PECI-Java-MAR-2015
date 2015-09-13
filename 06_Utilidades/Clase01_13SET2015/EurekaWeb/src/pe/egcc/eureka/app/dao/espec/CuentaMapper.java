package pe.egcc.eureka.app.dao.espec;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface CuentaMapper {
  
  void registrarRetiro(
      @Param("cuenta") String cuenta, 
      @Param("importe") Double importe,
      @Param("empleado") String empleado,
      @Param("clave") String clave);
  
  List<Map<String,Object>> getMovimientos(String cuenta);

}
