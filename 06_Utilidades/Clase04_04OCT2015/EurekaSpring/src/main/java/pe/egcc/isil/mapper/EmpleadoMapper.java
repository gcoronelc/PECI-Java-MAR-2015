package pe.egcc.isil.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.egcc.isil.model.EmpleadoBean;

public class EmpleadoMapper implements RowMapper<EmpleadoBean>{

  @Override
  public EmpleadoBean mapRow(ResultSet rs, int n) throws SQLException {
    EmpleadoBean empleadoBean = new EmpleadoBean();
    empleadoBean.setCodigo(rs.getString("CHR_EMPLCODIGO"));
    empleadoBean.setPaterno(rs.getString("VCH_EMPLPATERNO"));
    empleadoBean.setMaterno(rs.getString("VCH_EMPLMATERNO"));
    empleadoBean.setNombre(rs.getString("VCH_EMPLNOMBRE"));
    empleadoBean.setCiudad(rs.getString("VCH_EMPLCIUDAD"));
    empleadoBean.setDireccion(rs.getString("VCH_EMPLDIRECCION"));
    empleadoBean.setUsuario(rs.getString("VCH_EMPLUSUARIO"));
    return empleadoBean;
  }



}
