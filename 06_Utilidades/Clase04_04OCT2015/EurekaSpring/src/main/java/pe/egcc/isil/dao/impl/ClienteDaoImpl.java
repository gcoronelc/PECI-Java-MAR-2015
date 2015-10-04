package pe.egcc.isil.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.egcc.isil.dao.espec.ClienteDaoEspec;
import pe.egcc.isil.mapper.ClienteMapper;
import pe.egcc.isil.model.ClienteBean;

@Repository
public class ClienteDaoImpl extends AbstractDao implements ClienteDaoEspec{

  @Override
  public List<ClienteBean> getClientes(ClienteBean clienteBean) {
    String sql = "select "
        + "chr_cliecodigo, vch_cliepaterno, "
        + "vch_cliematerno, vch_clienombre, "
        + "chr_cliedni, vch_clieciudad, "
        + "vch_cliedireccion, vch_clietelefono, "
        + "vch_clieemail  from cliente "
        + "where chr_cliecodigo like ? "
        + "and vch_cliepaterno like ? "
        + "and vch_cliematerno like ? "
        + "and vch_clienombre like ? ";
    Object[] args = {
        clienteBean.getCodigo() + "%",
        clienteBean.getPaterno() + "%", 
        clienteBean.getMaterno() + "%",
        clienteBean.getNombre() + "%"
    };
    List<ClienteBean> lista;
    lista = jdbcTemplate.query(sql, args, new ClienteMapper());
    return lista;
  }

}
