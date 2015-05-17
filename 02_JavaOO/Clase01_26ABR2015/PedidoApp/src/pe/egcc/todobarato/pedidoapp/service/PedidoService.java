package pe.egcc.todobarato.pedidoapp.service;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class PedidoService {

  public double calcularImpuesto(double importe){
    double impuesto;
    impuesto = importe * 0.18;
    return impuesto;
  }
  
  public double calcularTotal(double importe){
    double total;
    total = importe + calcularImpuesto(importe);
    return total;
  }
  
}
