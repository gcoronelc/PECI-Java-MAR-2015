package pe.egcc.buensabor.ventaapp.Controller;

import pe.egcc.buensabor.ventaapp.model.ItemDto;
import pe.egcc.buensabor.ventaapp.service.CompFactory;
import pe.egcc.buensabor.ventaapp.service.ComprobanteAbstract;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class VentaController {

  public String[] traerTipos() {
    String[] tipos = {CompFactory.COMP_FACTURA, CompFactory.COMP_BOLETA};
    return tipos;
  }

  public ItemDto[] procesar(String tipo, double total) {
    ComprobanteAbstract comp = CompFactory.createComp(tipo);
    return comp.procesar(total);
  }

}
