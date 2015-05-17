package dao.design;

/**
 *
 * @author Gustavo Coronel
 */
public interface ICuentaDAO {

	public abstract void deposito(String cuenta, Double importe, String empleado) throws Exception;

	public abstract void retiro(String cuenta, String clave, Double importe, String empleado) throws Exception;

	public abstract boolean existe(String cuenta) throws Exception;
}