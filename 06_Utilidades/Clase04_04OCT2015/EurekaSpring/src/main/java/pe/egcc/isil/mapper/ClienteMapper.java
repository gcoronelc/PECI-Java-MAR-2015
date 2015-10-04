package pe.egcc.isil.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.egcc.isil.model.ClienteBean;

public class ClienteMapper implements RowMapper<ClienteBean>{

  @Override
  public ClienteBean mapRow(ResultSet rs, int n) throws SQLException {
    ClienteBean clienteBean = new ClienteBean();
    clienteBean.setCodigo(rs.getString("CHR_CLIECODIGO"));
    clienteBean.setPaterno(rs.getString("VCH_CLIEPATERNO"));
    clienteBean.setMaterno(rs.getString("VCH_CLIEMATERNO"));
    clienteBean.setNombre(rs.getString("VCH_CLIENOMBRE"));
    clienteBean.setDni(rs.getString("CHR_CLIEDNI"));
    clienteBean.setCiudad(rs.getString("VCH_CLIECIUDAD"));
    clienteBean.setDireccion(rs.getString("VCH_CLIEDIRECCION"));
    clienteBean.setTelefono(rs.getString("VCH_CLIETELEFONO"));
    clienteBean.setEmail(rs.getString("VCH_CLIEEMAIL"));
    return clienteBean;
  }
  
  
  
  
  
  
}
