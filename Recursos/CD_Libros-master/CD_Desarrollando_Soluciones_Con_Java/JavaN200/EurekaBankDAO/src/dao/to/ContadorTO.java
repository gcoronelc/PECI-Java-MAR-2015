package dao.to;

/**
 *
 * @author Gustavo Coronel
 */
public class ContadorTO {
	
	// Campos
	
	private String tabla = null;
	private Integer item = null;
	private Integer longitud = null;
	
	// Métodos
	
	public String getTabla() {
		return tabla;
	}
	
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	
	public Integer getItem() {
		return item;
	}
	
	public void setItem(Integer item) {
		this.item = item;
	}
	
	public Integer getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	
} // ContadorTO