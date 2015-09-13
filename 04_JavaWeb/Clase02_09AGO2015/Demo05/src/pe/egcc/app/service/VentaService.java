package pe.egcc.app.service;

import pe.egcc.app.model.VentaBean;

public class VentaService {

  public void procesar(VentaBean ventaBean){
    // Variables
    double total, impuesto, importe;
    // Calculos
    total = ventaBean.getPrecio() * ventaBean.getCantidad();
    importe = total / 1.18;
    impuesto = total - importe;
    // Salida
    ventaBean.setImporte(importe);
    ventaBean.setImpuesto(impuesto);
    ventaBean.setTotal(total);
  }
  
}
