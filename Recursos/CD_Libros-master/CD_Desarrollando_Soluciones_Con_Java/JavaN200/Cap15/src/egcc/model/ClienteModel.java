package egcc.model;

import egcc.accesodb.AccesoDB;
import egcc.to.ClienteTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteModel {

	public void insertar(ClienteTO clienteTO) throws Exception {

		Connection cn = null;
		PreparedStatement ps = null;
		String sql = null;
		try {
			// Obtenemos la conexión con la base de datos
			cn = AccesoDB.getConnection();
			// Deshabilitamos el auto-commit
			cn.setAutoCommit(false);
			// Obtenemos el código del nuevo cliente
			clienteTO.setCliecodigo(ContadorModel.getContador("Cliente"));
			// Preparamos la sentencia para grabar
			sql = "insert into cliente(chr_cliecodigo,vch_cliepaterno,vch_cliematerno," +
				"vch_clienombre,chr_cliedni,vch_clieciudad,vch_cliedireccion,vch_clietelefono," +
				"vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
			// Creamos el objeto PrepareStatement
			ps = cn.prepareStatement(sql);
			// Asignamos valores a los parámetros
			ps.setString(1, clienteTO.getCliecodigo());
			ps.setString(2, clienteTO.getCliepaterno());
			ps.setString(3, clienteTO.getCliematerno());
			ps.setString(4, clienteTO.getClienombre());
			ps.setString(5, clienteTO.getCliedni());
			ps.setString(6, clienteTO.getClieciudad());
			ps.setString(7, clienteTO.getCliedireccion());
			ps.setString(8, clienteTO.getClietelefono());
			ps.setString(9, clienteTO.getClieemail());
			// Ejecutamos
			ps.executeUpdate();
			// Confirmamos la transacción
			cn.commit();
			// Cerramos el objeto PreparedStatement
			ps.close();
		} catch (Exception e) {
			try {
				// Cancelamos la transacción
				cn.rollback();
			} catch (SQLException ex) {}
			throw e;
		}

	} // insertar
	
	public void modificar(ClienteTO clienteTO) throws Exception {
		
		Connection cn = null;
		CallableStatement cs = null;
		String estado = null;
		String sql = null;
		
		try {
			// Obtenemos la conexión con la base de datos
			cn = AccesoDB.getConnection();
			// Deshabilitamos el auto-commit
			cn.setAutoCommit(true);
			// Preparamos el procedimiento
			sql = "{call usp_actualiza_datos_cliente(?,?,?,?,?,?,?,?,?,?)}";
			// Preparamos la sentencia
			cs = cn.prepareCall(sql);
			// Establecemos los parametros
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.setString(2, clienteTO.getCliecodigo());
			cs.setString(3, clienteTO.getCliepaterno());
			cs.setString(4, clienteTO.getCliematerno());
			cs.setString(5, clienteTO.getClienombre());
			cs.setString(6, clienteTO.getCliedni());
			cs.setString(7, clienteTO.getClieciudad());
			cs.setString(8, clienteTO.getCliedireccion());
			cs.setString(9, clienteTO.getClietelefono());
			cs.setString(10, clienteTO.getClieemail());
			// Ejecutar el proceso
			cs.executeUpdate();
			// Obtenemos el valor de estado
			estado = cs.getString(1);
			// Verificamos el estado
			if( estado != null){
				// Lanzamos la excepción
				throw new Exception(estado);
			}
			cs.close();
		} catch (Exception e) {
			throw e;
		}
		
	} // modificar
	
} // ClienteModel