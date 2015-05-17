package pe.jaa.isil.distanciapuntos.model;

import pe.jaa.isil.distanciapuntos.dto.Punto;
import pe.jaa.isil.distanciapuntos.dto.Segmento;

/**
 *
 * @author Javier Aching Acosta
 */
public class DistanciaModel {

  public void cuadrante(Punto pto) {
    //Variables
    String cuadrante;
    //Proceso
    if (pto.getX() > 0 && pto.getY() > 0) {
      cuadrante = "I";
    } else if (pto.getX() > 0 && pto.getY() < 0) {
      cuadrante = "II";
    } else if (pto.getX() < 0 && pto.getY() < 0) {
      cuadrante = "III";
    } else if (pto.getX() < 0 && pto.getY() > 0) {
      cuadrante = "IV";
    } else {
      cuadrante = "EJE";
    }
    //Salida
    pto.setCuadrante(cuadrante);
  }

  public void distancia(Segmento sgm) {
    //Variables
    double d = 0.0;
    //Proceso
    d = Math.hypot(sgm.getP2().getX() - sgm.getP1().getX(), sgm.getP2().getY() - sgm.getP1().getY());
    //Salida
    sgm.setDistancia(d);
  }
  
  public void procesar(Segmento seg){
    cuadrante(seg.getP1());
    cuadrante(seg.getP2());
    distancia(seg);
  }
}
