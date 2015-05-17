package dao;

import dao.component.ClienteDAO;
import dao.component.ContadorDAO;
import dao.component.CuentaDAO;
import dao.component.EmpleadoDAO;
import dao.component.SucursalDAO;
import dao.design.IClienteDAO;
import dao.design.IContadorDAO;
import dao.design.ICuentaDAO;
import dao.design.IEmpleadoDAO;
import dao.design.ISucursalDAO;
import dao.to.SucursalTO;

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

	public IContadorDAO getContadorDAO() {
		return new ContadorDAO();
	}

	public IClienteDAO getClienteDAO() {
		return new ClienteDAO();
	}

	public ISucursalDAO getSucursalDAO() {
		return new SucursalDAO();
	}
	
	public ICuentaDAO getCuentaDAO(){
		return new CuentaDAO();
	}
}