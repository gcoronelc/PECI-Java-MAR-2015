package dao.component;

import dao.design.IContadorDAO;
import dao.ds.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.to.ContadorTO;

public class ContadorDAO implements IContadorDAO {

	public ContadorTO consultar(String tabla) throws Exception {
		Connection cn = AccesoDB.getConnection();
		String sql = "select * from contador where vch_conttabla = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, tabla);
		ResultSet rs = ps.executeQuery();
		ContadorTO contadorTO = null;
		if(rs.next()){
			contadorTO = new ContadorTO();
            contadorTO.setTabla(rs.getString("vch_conttabla"));
            contadorTO.setItem(rs.getInt("int_contitem"));
            contadorTO.setLongitud(rs.getInt("int_contlongitud"));
		}
		return contadorTO;
	}
	
	public String generaCodigo(String tabla) throws Exception {
		ContadorTO contadorTO = this.consultar(tabla);
		if( contadorTO == null ){
			throw new Exception("Nombre de tabla no existe.");
		}
		String codigo = null;
		String sql = "update contador set int_contitem = int_contitem + 1 " +
		"where vch_conttabla = ?";
		Connection cn = AccesoDB.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, tabla);
		ps.executeUpdate();
		for(int k = 1; k <= contadorTO.getLongitud(); k++){
			codigo = codigo + "0";
		}
		codigo = codigo + String.valueOf(contadorTO.getItem());
		codigo = codigo.substring(codigo.length() - contadorTO.getLongitud());
		return codigo;
	}

} // ContadorDAO