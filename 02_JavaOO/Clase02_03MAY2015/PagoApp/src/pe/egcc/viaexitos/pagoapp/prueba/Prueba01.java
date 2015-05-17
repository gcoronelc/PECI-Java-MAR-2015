package pe.egcc.viaexitos.pagoapp.prueba;

import pe.egcc.viaexitos.pagoapp.dto.PagoDto;
import pe.egcc.viaexitos.pagoapp.model.PagoModel;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    PagoDto dto = new PagoDto();
    dto.setHorasDia(6);
    dto.setDias(20);
    dto.setPagoHora(100.0);
    // Proceso
    PagoModel pm = new PagoModel();
    pm.procesar(dto);
    // Reporte
    System.out.println("Ingresos: " + dto.getIngresos());
    System.out.println("Renta: " + dto.getRenta());
    System.out.println("Neto: " + dto.getNeto());
  }
  
}
