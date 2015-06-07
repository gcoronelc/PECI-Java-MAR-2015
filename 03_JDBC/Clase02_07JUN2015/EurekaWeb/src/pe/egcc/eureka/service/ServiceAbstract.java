package pe.egcc.eureka.service;

import org.apache.ibatis.session.SqlSessionFactory;

import pe.egcc.eureka.dao.MyBatisConnectionFactory;

public abstract class ServiceAbstract {
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public ServiceAbstract() {
    sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
  }
  

}
