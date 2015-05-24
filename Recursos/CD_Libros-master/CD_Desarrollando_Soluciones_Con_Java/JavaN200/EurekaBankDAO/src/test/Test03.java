package test;

import dao.DAOFactory;
import dao.design.ICuentaDAO;

/**
 *
 * @author Gustavo Coronel
 */
public class Test03 {

	public static void main(String[] args) {
		try {
			String cuenta = "00100055";
			ICuentaDAO cuentaDAO = DAOFactory.getInstance().getCuentaDAO();
			if( !cuentaDAO.existe(cuenta) ){
				throw new Exception("Cuenta no existe.");
			}
			cuentaDAO.deposito(cuenta, 100.0, "0001");
			System.out.println("Deposito Ok.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}