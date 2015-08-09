package pe.jaa.app.service;

import pe.jaa.app.model.PagoBean;


public class PagoService {
	
	public void procesar(PagoBean pagoBean){
	    // Variables
	    double importe, impuesto = 0.0, total;
	    // Calculos
	    importe = pagoBean.getHorasTrabajadas() * pagoBean.getDiasTrabajados() * pagoBean.getPagoPorHora();
	    if (importe > 1500) {
			impuesto = importe *0.10;
			total = importe - impuesto;
		} else {
			total = importe;
		}
	    // Salida
	    pagoBean.setImporte(importe);
	    pagoBean.setImpuesto(impuesto);
	    pagoBean.setTotal(total);
	  }

}
