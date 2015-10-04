package pe.egcc.isil.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.egcc.isil.dao.espec.CuentaDaoEspec;

@Repository
public class CuentaDaoImpl extends AbstractDao implements CuentaDaoEspec{

  @Override
  public List<Map<String, Object>> getMovimientos(String cuenta) {
    String sql = "select "
        + "m.chr_cuencodigo cuenta, "
        + "m.int_movinumero nromov, "
        + "m.dtt_movifecha fecha, "
        + "m.chr_emplcodigo empleado, "
        + "t.vch_tipodescripcion tipo, "
        + "t.vch_tipoaccion accion, "
        + "m.dec_moviimporte importe "
        + "from movimiento m "
        + "join tipomovimiento t "
        + "on m.chr_tipocodigo = t.chr_tipocodigo "
        + "where m.chr_cuencodigo = ? "
        + "order by m.int_movinumero";
    List<Map<String, Object>> lista;
    Object[] args = {cuenta};
    lista = jdbcTemplate.queryForList(sql, args);
    return lista;
  }

}
