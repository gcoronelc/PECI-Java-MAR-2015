package pe.egcc.buensabor.ventaapp.service;

import pe.egcc.buensabor.ventaapp.model.ItemDto;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public abstract class ComprobanteAbstract {

  public abstract ItemDto[] procesar(double total);

}
