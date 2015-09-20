package pe.egcc.eureka.app.service;

import org.apache.ibatis.session.SqlSessionFactory;

import pe.egcc.eureka.app.dao.MyBatisConnectionFactory;

public abstract class AbstractService {
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public AbstractService() {
    sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
  }
  

}
