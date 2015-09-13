package pe.egcc.eureka.app.model;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class ContadorBean {

  private String tabla;
  private Integer contador;
  private Integer longitud;

  public ContadorBean() {
  }

  public String getTabla() {
    return tabla;
  }

  public void setTabla(String tabla) {
    this.tabla = tabla;
  }

  public Integer getContador() {
    return contador;
  }

  public void setContador(Integer contador) {
    this.contador = contador;
  }

  public Integer getLongitud() {
    return longitud;
  }

  public void setLongitud(Integer longitud) {
    this.longitud = longitud;
  }

}
