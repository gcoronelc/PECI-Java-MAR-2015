package pe.egcc.buensabor.ventaapp.prueba;

import pe.egcc.buensabor.ventaapp.model.ItemDto;
import pe.egcc.buensabor.ventaapp.service.FacturaService;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba01 {
  public static void main(String[] args) {
    double total = 456.87;
    FacturaService fs = new FacturaService();
    ItemDto[] repo = fs.procesar(total);
    for (ItemDto dto : repo) {
      System.out.println(dto.getConcepto() + " => " + dto.getValor());
    }
  }

}
