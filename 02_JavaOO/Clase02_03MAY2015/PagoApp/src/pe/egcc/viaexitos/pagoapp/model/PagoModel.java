package pe.egcc.viaexitos.pagoapp.model;

import pe.egcc.viaexitos.pagoapp.dto.PagoDto;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class PagoModel {

  public void procesar(PagoDto dto){
    // Variables
    double ingresos, renta, neto;
    // Proceso
    ingresos = dto.getHorasDia() * dto.getDias() * dto.getPagoHora();
    if(ingresos > 1500.0)
      renta = ingresos * 0.10;
    else
      renta = 0.0;
    neto = ingresos - renta;
    // Salida
    dto.setIngresos(ingresos);
    dto.setRenta(renta);
    dto.setNeto(neto);
  }
}
