package pe.egcc.buensabor.ventaapp.prueba;

import pe.egcc.buensabor.ventaapp.model.ItemDto;
import pe.egcc.buensabor.ventaapp.service.CompFactory;
import pe.egcc.buensabor.ventaapp.service.ComprobanteAbstract;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba03 {
  public static void main(String[] args) {
    double total = 456.87;
    ComprobanteAbstract comp;
    comp = CompFactory.createComp(CompFactory.COMP_BOLETA);
    ItemDto[] repo = comp.procesar(total);
    for (ItemDto dto : repo) {
      System.out.println(dto.getConcepto() + " => " + dto.getValor());
    }
  }

}
