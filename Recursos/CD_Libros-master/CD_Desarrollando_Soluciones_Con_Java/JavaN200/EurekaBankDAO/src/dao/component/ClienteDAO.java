package dao.component;

import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.design.IContadorDAO;
import dao.ds.AccesoDB;
import dao.to.ClienteTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gustavo Coronel
 */
public class ClienteDAO implements IClienteDAO {

	public void insertar(ClienteTO clienteTO) throws Exception {
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
			String codigo = contadorDAO.generaCodigo("cliente");
			String sql = "insert into cliente(chr_cliecodigo,vch_cliepaterno,vch_cliematerno," +
			"vch_clienombre,chr_cliedni,vch_clieciudad,vch_cliedireccion,vch_clietelefono," +
			"vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, clienteTO.getPaterno());
			ps.setString(3, clienteTO.getMaterno());
			ps.setString(4, clienteTO.getNombre());
			ps.setString(5, clienteTO.getDni());
			ps.setString(6, clienteTO.getCiudad());
			ps.setString(7, clienteTO.getDireccion());
			ps.setString(8, clienteTO.getTelefono());
			ps.setString(9, clienteTO.getEmail());
			ps.executeUpdate();
			clienteTO.setCodigo(codigo);
			cn.commit();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw e;
		}
	}
}