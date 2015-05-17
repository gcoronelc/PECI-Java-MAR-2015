package pe.egcc.app.model;

import java.io.Serializable;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 */
public class Articulo implements Serializable{

  private String nombre;
  private double precio;

  public Articulo() {
  }

  public Articulo(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  
}
