package test;

import dao.DAOFactory;
import dao.design.ICuentaDAO;

/**
 *
 * @author Gustavo Coronel
 */
public class Test04 {

	public static void main(String[] args) {
		try {
			ICuentaDAO cuentaDAO = DAOFactory.getInstance().getCuentaDAO();
			cuentaDAO.retiro("00100001", "123456", 100.0, "0001");
			System.out.println("Retiro Ok.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}
}
