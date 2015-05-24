package agregacion;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
	
public class Cliente {

	private String nombre = null;
	private String dni = null;
	private GregorianCalendar fechaNacimiento = null;

	public Cliente(String nombre, String dni, GregorianCalendar fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyy hh:mm");
		return this.getNombre() + "\t" + 
			this.getDni() + "\t" + sdf.format(this.getFechaNacimiento().getTime());
	}
	
} // Cliente