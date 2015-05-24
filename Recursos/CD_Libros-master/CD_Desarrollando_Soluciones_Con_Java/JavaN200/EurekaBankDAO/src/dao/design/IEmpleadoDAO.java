package dao.design;

import dao.to.EmpleadoTO;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Coronel
 */
public interface IEmpleadoDAO {

	public abstract ArrayList<EmpleadoTO> consultarPorSucursal(String sucursal) throws Exception;

	public abstract EmpleadoTO consultarPorUsuario(String usuario) throws Exception;

	public abstract ArrayList<EmpleadoTO> consultarPorPaterno(String paterno) throws Exception;
}