package pe.jaa.isil.distanciapuntos.controller;

import pe.jaa.isil.distanciapuntos.dto.Punto;
import pe.jaa.isil.distanciapuntos.dto.Segmento;
import pe.jaa.isil.distanciapuntos.model.DistanciaModel;

/**
 *
 * @author Javier Aching Acosta
 */
public class DistanciaController {

  public void cuadrante1(Punto pto1) {
    DistanciaModel dm = new DistanciaModel();
    dm.cuadrante(pto1);
  }

  public void cuadrante2(Punto pto2) {
    DistanciaModel dm = new DistanciaModel();
    dm.cuadrante(pto2);
  }

  public void procesar(Segmento sgm) {
    DistanciaModel dm = new DistanciaModel();
    dm.procesar(sgm);
  }

}
