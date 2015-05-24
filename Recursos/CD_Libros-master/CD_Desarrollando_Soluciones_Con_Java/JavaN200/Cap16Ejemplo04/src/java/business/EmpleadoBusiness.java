package business;

import dao.DAOFactory;
import dao.design.IEmpleadoDAO;
import dao.to.EmpleadoTO;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Coronel
 */
public class EmpleadoBusiness {

	public ArrayList<EmpleadoTO> consultarPorSucursal(String sucursal) throws Exception {
		IEmpleadoDAO empleadoDAO = DAOFactory.getInstance().getEmpleadoDAO();
		return empleadoDAO.consultarPorSucursal(sucursal);
	}
}