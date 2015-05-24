package dao.design;

import dao.to.ClienteTO;

/**
 *
 * @author Gustavo Coronel
 */
public interface IClienteDAO {

	public void insertar( ClienteTO clienteTO ) throws Exception;
}
