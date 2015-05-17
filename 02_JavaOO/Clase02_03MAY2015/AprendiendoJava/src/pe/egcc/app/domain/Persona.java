package pe.egcc.app.domain;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Persona {

  private String nombre;
  private String telefono;
  private String email;

  /**
   * constructor por defecto
   */
  public Persona() {
    this("GUSTAVO", "996664457", "GCORONELC@GMAIL.COM");
  }

  /**
   * Constructor adicional
   *
   * @param nombre
   */
  public Persona(String nombre) {
    this(nombre, "6578345", "GCORONELC@GMAIL.COM");
  }

  /**
   * Constructor adicional
   *
   * @param nombre
   * @param telefono
   */
  public Persona(String nombre, String telefono) {
    this(nombre, telefono, "ALGO@GMAIL.COM");
  }

  /**
   * Constructor adicional
   *
   * @param nombre
   * @param telefono
   * @param email
   */
  public Persona(String nombre, String telefono, String email) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "[" + nombre + "," + telefono + "," + email + "]";
  }

  
}
