package egcc.pruebas;

import egcc.model.ClienteModel;
import egcc.to.ClienteTO;

public class Prueba02 {

	public static void main(String[] args) {
	
		// Creación de los objetos
		ClienteTO clienteTO = new ClienteTO();
		ClienteModel cliente = new ClienteModel();
		
		// Preparamos los datos
		clienteTO.setCliepaterno("GUARACHI");
		clienteTO.setCliematerno("CORONEL");
		clienteTO.setClienombre("ALEJANDRA MARIEL");
		clienteTO.setCliedni("10459823");
		clienteTO.setClieciudad("CHICLAYO");
		clienteTO.setCliedireccion("BARCELONA 2345");
		clienteTO.setClietelefono("234567");
		clienteTO.setClieemail("aleguarachi@hotmail.com");
		
		//Grabamos en la base de datos
		try {
			cliente.insertar(clienteTO);
			System.out.println("Código Generado: " + clienteTO.getCliecodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	} // main
	
} // Prueba02
//Código Generado: 00021