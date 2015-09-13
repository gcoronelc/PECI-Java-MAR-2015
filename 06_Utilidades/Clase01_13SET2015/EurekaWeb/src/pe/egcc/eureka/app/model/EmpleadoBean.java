package pe.egcc.eureka.app.model;

public class EmpleadoBean {

  private String codigo;
  private String paterno;
  private String materno;
  private String nombre;
  private String ciudad;
  private String direccion;
  private String usuario;

  public EmpleadoBean() {
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getPaterno() {
    return paterno;
  }

  public void setPaterno(String paterno) {
    this.paterno = paterno;
  }

  public String getMaterno() {
    return materno;
  }

  public void setMaterno(String materno) {
    this.materno = materno;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public void establecerDatos() {
    if (codigo == null) {
      codigo = "";
    }
    if (paterno == null) {
      paterno = "";
    }
    if (materno == null) {
      materno = "";
    }
    if (nombre == null) {
      nombre = "";
    }
    if (ciudad == null) {
      ciudad = "";
    }
    if (direccion == null) {
      direccion = "";
    }
    if (usuario == null) {
      usuario = "";
    }
  }

}
