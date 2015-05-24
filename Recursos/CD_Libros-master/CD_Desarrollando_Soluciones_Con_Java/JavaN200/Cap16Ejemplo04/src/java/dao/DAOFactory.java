package dao;

import dao.component.EmpleadoDAO;
import dao.design.IEmpleadoDAO;

/**
 *
 * @author Gustavo Coronel
 */
public class DAOFactory {

	private static DAOFactory daoFac;
	
	static {
		daoFac = new DAOFactory();
	}

	public static DAOFactory getInstance() {
		return daoFac;
	}

	public IEmpleadoDAO getEmpleadoDAO() {
		return new EmpleadoDAO();
	}
	
}