package pe.egcc.isil.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AbstractDao {
  
  protected JdbcTemplate jdbcTemplate;
  
  @Autowired
  public void setDatasource(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

}
