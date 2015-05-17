package agregacion;

import java.util.ArrayList;

public class Banco {

	private String nombre = null;
	private String direccion = null;
	private ArrayList<Cliente> clientes = null;
	
	
	public Banco(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.clientes = new ArrayList<Cliente>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void agregarCliente(Cliente cliente){
		this.clientes.add(cliente);
	}
	
	public ArrayList<Cliente> getClientes(){
		return this.clientes;
	}
	
} // Banco
