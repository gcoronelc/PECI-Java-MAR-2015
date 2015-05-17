package model;

import dao.DAOFactory;
import dao.design.IEmpleadoDAO;
import dao.to.EmpleadoTO;

/**
 *
 * @author gustavo
 */
public class EmpleadoModel {

	public boolean verificarUsuario(String usuario, String clave) throws Exception {
		IEmpleadoDAO empleadoDAO = DAOFactory.getInstance().getEmpleadoDAO();
		EmpleadoTO empleadoTO = empleadoDAO.consultarPorUsuario(usuario);
		if (empleadoTO == null) {
			return false;
		}
		boolean rpta = false;
		if (empleadoTO.getClave().equals(clave)) {
			rpta = true;
		}
		return true;
	}

	public EmpleadoTO consultarPorUsuario(String usuario) throws Exception {
		IEmpleadoDAO empleadoDAO = DAOFactory.getInstance().getEmpleadoDAO();
		EmpleadoTO empleadoTO = empleadoDAO.consultarPorUsuario(usuario);
		return empleadoTO;
	}
}
