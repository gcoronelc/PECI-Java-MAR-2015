package model;

import dao.DAOFactory;
import dao.design.ICuentaDAO;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaModel {

	public void deposito(String cuenta, Double importe, String empleado) throws Exception {
		ICuentaDAO cuentaDAO = DAOFactory.getInstance().getCuentaDAO();
		if (!cuentaDAO.existe(cuenta)) {
			throw new Exception("Cuenta no Existe.");
		}
		cuentaDAO.deposito(cuenta, importe, empleado);
	}
	
	public void retiro(String cuenta, String clave, Double importe, String empleado) throws Exception {
		ICuentaDAO cuentaDAO = DAOFactory.getInstance().getCuentaDAO();
		if (!cuentaDAO.existe(cuenta)) {
			throw new Exception("Cuenta no Existe.");
		}
		cuentaDAO.retiro(cuenta, clave, importe, empleado);
	}
}
