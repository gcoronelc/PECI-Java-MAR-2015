package model;

import dao.DAOFactory;
import dao.design.ISucursalDAO;
import dao.to.SucursalTO;

/**
 *
 * @author Gustavo Coronel
 */
public class SucursalModel {

	public SucursalTO consultarPorEmpleado(String codigo) throws Exception {
		ISucursalDAO sucursalDAO = DAOFactory.getInstance().getSucursalDAO();
		SucursalTO sucursalTO = sucursalDAO.consultaPorEmpleado(codigo);
		return sucursalTO;
	}
}