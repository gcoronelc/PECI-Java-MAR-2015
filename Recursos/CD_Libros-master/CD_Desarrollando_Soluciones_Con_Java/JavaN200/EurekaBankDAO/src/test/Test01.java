// Probar el método actualizar de la clase MySQLContadorDAO

package test;

import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.to.ClienteTO;

public class Test01 {

	public static void main(String[] args) {
		// Datos
		ClienteTO clienteTO = new ClienteTO();
		clienteTO.setPaterno("Ramos");
		clienteTO.setMaterno("Diaz");
		clienteTO.setNombre("José Manuel");
		clienteTO.setDni("65347659");
		clienteTO.setCiudad("Lima");
		clienteTO.setDireccion("Av. 2 de Mayo 4576");
		clienteTO.setTelefono("456-3245");
		clienteTO.setEmail("jramos@gmail.com");
		try {
			IClienteDAO clienteDAO= DAOFactory.getInstance().getClienteDAO();
			clienteDAO.insertar(clienteTO);
			System.out.println("Código generado: " + clienteTO.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
	
} // Test06