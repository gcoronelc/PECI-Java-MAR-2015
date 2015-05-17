package pe.egcc.app.domain;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Estudiante {

  private Integer codigo;
  private String nombre;
  private Integer nota;

  /**
   * Constructor por defecto
   */
  public Estudiante() {
  }

  /**
   * Constructor con parametros
   *
   * @param codigo
   * @param nombre
   * @param nota
   */
  public Estudiante(Integer codigo, String nombre, Integer nota) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.nota = nota;
  }

  /* Métodos getters and setters */
  
  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }

}
