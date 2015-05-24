package dao.component;

import dao.design.ISucursalDAO;
import dao.ds.AccesoDB;
import dao.to.SucursalTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gustavo Coronel
 */
public class SucursalDAO implements ISucursalDAO {

    public SucursalTO consultaPorEmpleado(String codigo) throws Exception {
        String query = "select * from sucursal " +
                "where chr_sucucodigo in " +
                "(select chr_sucucodigo from asignado " +
                "where chr_emplcodigo = ? " +
                "and dtt_asigfechabaja is null)";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        SucursalTO sucursalTO = null;
        if (rs.next()) {
            sucursalTO = new SucursalTO();
            sucursalTO.setCodigo(rs.getString("chr_sucucodigo"));
            sucursalTO.setNombre(rs.getString("vch_sucunombre"));
            sucursalTO.setCiudad(rs.getString("vch_sucuciudad"));
            sucursalTO.setDireccion(rs.getString("vch_sucudireccion"));
            sucursalTO.setContcuenta(rs.getString("int_sucucontcuenta"));
        }
        return sucursalTO;
    }

}
