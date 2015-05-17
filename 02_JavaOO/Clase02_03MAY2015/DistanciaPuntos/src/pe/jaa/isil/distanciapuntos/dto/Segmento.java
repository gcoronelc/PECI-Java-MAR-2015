package pe.jaa.isil.distanciapuntos.dto;
/**
 *
 * @author Javier Aching Acosta
 */
public class Segmento {
    
    private Punto p1;
    private Punto p2;
    private double distancia;
    
    public Segmento(){
        p1 = null;
        p2 = null;
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}
