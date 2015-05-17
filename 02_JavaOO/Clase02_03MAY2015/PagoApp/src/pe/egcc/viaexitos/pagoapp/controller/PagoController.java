package pe.egcc.viaexitos.pagoapp.controller;

import pe.egcc.viaexitos.pagoapp.dto.PagoDto;
import pe.egcc.viaexitos.pagoapp.model.PagoModel;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class PagoController {

  public void procesar(PagoDto dto) {
    PagoModel pm = new PagoModel();
    pm.procesar(dto);
  }

}
