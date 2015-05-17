package pe.egcc.model;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Producto {

  private String nombre;
  private double precio;
  private int stock;

  public Producto() {
    // Inicializar el objeto
    this.nombre = "Desayuno";
    this.precio = 8.0;
    this.stock = 20;
    System.out.println("Objecto creado.");
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

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  protected void finalize() throws Throwable {
    System.err.println("Chau objeto");
  }
  
  

}
