package canasta;

/**
 *
 * @author Gustavo Coronel
 */
public class CanastaItem {

	private String articulo;
	private Double precio;
	private Integer cantidad;
	private Double subtotal;

	public CanastaItem() {
		setArticulo(null);
		setCantidad(0);
		setPrecio(0.0);
	}

	private void calcularSubtotal() {
		Double st;
		try {
			st = getPrecio() * getCantidad();	
		} catch (Exception e) {
			st = 0.0;
		}
		setSubtotal(st);
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
		calcularSubtotal();
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
		calcularSubtotal();
	}

	public Double getSubtotal() {
		return subtotal;
	}

	private void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}