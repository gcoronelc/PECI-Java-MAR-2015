package pe.egcc.buensabor.ventaapp.service;

import pe.egcc.buensabor.ventaapp.model.ItemDto;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class FacturaService extends ComprobanteAbstract{

  @Override
  public ItemDto[] procesar(double total) {
    // Variables
    double consumo, impuesto, servicio, totalGeneral;
    // Calculos
    consumo = total / 1.18;
    impuesto = total - consumo;
    servicio = total * 0.10;
    totalGeneral = total + servicio;
    // Reporte
    ItemDto[] repo = {
      new ItemDto("Consumo", consumo),
      new ItemDto("Impuesto", impuesto),
      new ItemDto("Total", total),
      new ItemDto("Servicio", servicio),
      new ItemDto("Total General", totalGeneral),
    };
    return repo;
  }

}
