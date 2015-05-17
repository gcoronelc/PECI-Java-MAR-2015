package pe.egcc.buensabor.ventaapp.prueba;

import pe.egcc.buensabor.ventaapp.model.ItemDto;
import pe.egcc.buensabor.ventaapp.service.BoletaService;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Prueba02 {
  public static void main(String[] args) {
    double total = 456.87;
    BoletaService bs = new BoletaService();
    ItemDto[] repo = bs.procesar(total);
    for (ItemDto dto : repo) {
      System.out.println(dto.getConcepto() + " => " + dto.getValor());
    }
  }

}
