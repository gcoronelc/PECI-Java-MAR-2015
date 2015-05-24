package dao.to;

/**
 *
 * @author Gustavo Coronel
 */
public class SucursalTO {

    private String codigo = null;
    private String nombre = null;
    private String ciudad = null;
    private String direccion = null;
    private String contcuenta = null;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getContcuenta() {
        return contcuenta;
    }

    public void setContcuenta(String contcuenta) {
        this.contcuenta = contcuenta;
    }
    
}
