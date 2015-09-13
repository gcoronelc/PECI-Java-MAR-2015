package pe.egcc.eureka.app.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class MyBatisConnectionFactory {
  
  private MyBatisConnectionFactory() {
  }

  private static SqlSessionFactory sqlSessionFactory;

  static {
    try {

      String resource = "pe/egcc/eureka/app/dao/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);

      if (sqlSessionFactory == null) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }
      
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    }
  }

  public static SqlSessionFactory getSqlSessionFactory() {
    return sqlSessionFactory;
  }

}
