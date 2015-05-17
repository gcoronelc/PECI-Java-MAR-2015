package pe.egcc.buensabor.ventaapp.service;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public final class CompFactory {
  
  public static final String COMP_FACTURA = "Factura";
  public static final String COMP_BOLETA = "Boleta";

  private CompFactory() {
  }

  public static ComprobanteAbstract createComp(String tipo){
    ComprobanteAbstract bean = null;
    switch(tipo){
      case COMP_FACTURA:
        bean = new FacturaService();
        break;
      case COMP_BOLETA:
        bean = new BoletaService();
        break;
    }
    return bean;
  }
  
  
}
