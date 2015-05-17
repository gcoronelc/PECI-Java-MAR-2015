package dao.component;

import dao.design.IEmpleadoDAO;
import dao.ds.AccesoDB;
import dao.to.EmpleadoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Coronel
 */
public class EmpleadoDAO implements IEmpleadoDAO{

	public ArrayList<EmpleadoTO> consultarPorSucursal(String sucursal) throws Exception {
		String query = "select * from empleado where chr_emplcodigo " +
			"in (select chr_emplcodigo from asignado where chr_sucucodigo = ?)";
		PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
		ps.setString(1, sucursal);
		ResultSet rs = ps.executeQuery();
		ArrayList<EmpleadoTO> lista = new ArrayList<EmpleadoTO>();
		EmpleadoTO empl = null;
		while( rs.next() ){
			empl = new EmpleadoTO();
			empl.setCodigo(rs.getString("chr_emplcodigo"));
			empl.setPaterno(rs.getString("vch_emplpaterno"));
			empl.setMaterno(rs.getString("vch_emplmaterno"));
			empl.setNombre(rs.getString("vch_emplnombre"));
			empl.setCiudad(rs.getString("vch_emplciudad"));
			empl.setDireccion(rs.getString("vch_empldireccion"));
			empl.setUsuario(rs.getString("vch_emplusuario"));
			empl.setClave(rs.getString("vch_emplclave"));
			lista.add(empl);
		}
		rs.close();
		ps.close();
		return lista;
	}

}