package pe.egcc.isil.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.egcc.isil.dao.espec.EmpleadoDaoEspec;
import pe.egcc.isil.mapper.EmpleadoMapper;
import pe.egcc.isil.model.EmpleadoBean;

@Repository
public class EmpleadoDaoImpl extends AbstractDao implements EmpleadoDaoEspec{

  @Override
  public EmpleadoBean getEmpleadoPorUsuario(String usuario, String clave) {
    String sql = "select chr_emplcodigo, vch_emplpaterno,"
        + "vch_emplmaterno, vch_emplnombre, "
        + "vch_emplciudad, vch_empldireccion,"
        + "vch_emplusuario  "
        + "from empleado "
        + "where vch_emplusuario = ? "
        + "and vch_emplclave = ? "
        + "and chr_emplcodigo in ( "
        + "select chr_emplcodigo "
        + "from asignado "
        + "where dtt_asigfechabaja is null)";
    Object[] args = {usuario,clave};
    EmpleadoBean empleadoBean;
    empleadoBean = jdbcTemplate.queryForObject(sql, args, new EmpleadoMapper());
    return empleadoBean;
  }

  @Override
  public List<EmpleadoBean> getEmpleados(EmpleadoBean empleadoBean) {
    // TODO Auto-generated method stub
    return null;
  }

}
