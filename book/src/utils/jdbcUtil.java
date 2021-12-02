package utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author jingpengtao
 * @create 2021-09-23 19:07
 */
public class jdbcUtil {
     private static DataSource dataSource;
    private static Connection connections;
  static{

      try {
          Properties info = new Properties();
          InputStream stream = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
          info.load(stream);
          dataSource = DruidDataSourceFactory.createDataSource(info);
      } catch (Exception e) {
          e.printStackTrace();
      }

  }
  public static Connection getConnections(){
      Connection connections = null;
      try {
           connections = dataSource.getConnection();

      } catch (SQLException e) {
          e.printStackTrace();
      }
      return connections;
  }
  public static void close(){
      try {
          if(connections!=null)
              connections.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

}
