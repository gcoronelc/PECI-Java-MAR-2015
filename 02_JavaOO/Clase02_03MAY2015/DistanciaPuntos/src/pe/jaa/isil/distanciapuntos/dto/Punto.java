package pe.jaa.isil.distanciapuntos.dto;
/**
 *
 * @author Javier Aching Acosta
 */
public class Punto {
    
    private int x;
    private int y;
    private String cuadrante;
    
    public Punto(){
        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(String cuadrante) {
        this.cuadrante = cuadrante;
    }
    
}
