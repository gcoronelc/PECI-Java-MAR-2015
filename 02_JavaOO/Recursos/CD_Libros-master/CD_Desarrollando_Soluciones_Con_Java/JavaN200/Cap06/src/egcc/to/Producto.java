package egcc.to;

public class Producto implements Comparable {

	// Campos
	private String nombre = null;
	private double precio;
	// Constructor
	public Producto(String nombre, double precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	} // Producto

	// Métodos
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

	@Override
	public String toString() {
		return this.getNombre() + " - " + this.getPrecio();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Producto) {
			Producto producto = (Producto) obj;
			return this.getNombre().equals(producto.getNombre());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.getNombre().hashCode();
	}

	public int compareTo(Object obj) {
		// Indica en base a que atributos se compara el objeto
		// Devuelve +1 si this es > que objeto
		// Devuelve -1 si this es < que objeto
		// Devuelve  0 si son iguales
		Producto producto = (Producto) obj;
		String nombreObj = producto.getNombre().toLowerCase();
		String nombreThis = this.getNombre().toLowerCase();
		return (nombreThis.compareTo(nombreObj));
	}
} // Producto