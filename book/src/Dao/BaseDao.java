package Dao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @author jingpengtao
 * @create 2021-09-23 19:27
 */
public abstract class BaseDao {
   private static QueryRunner qr = new QueryRunner();

    //增删改操作
    public static int crud(String sql,Object...arg){
        Connection connections = jdbcUtil.getConnections();
        int update=0;
        try {
             update = qr.update(connections, sql, arg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcUtil.close();
        return update;
    }
//查询单条记录
    public static <T> T querone(Class<T> type,String sql,Object...arg){
        Connection connections = jdbcUtil.getConnections();
        T query=null;
        try {
            query = qr.query(connections, sql, new BeanHandler<T>(type), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcUtil.close();

        return query;
    }
    //查询多条记录
    public static <T> List<T> querm(Class<T> clazz,String sql,Object...arg){
        Connection connections = jdbcUtil.getConnections();
        List<T> query = null;
        try {
            query = qr.query(connections, sql, new BeanListHandler<T>(clazz), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcUtil.close();
        return query;
    }
    //查询特殊记录
    public static Object quermt(String sql,Object...arg){
        Connection connections = jdbcUtil.getConnections();
        Object  query=null;
        try {
            query = qr.query(connections, sql, new ScalarHandler(), arg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcUtil.close();
        return query;
    }
}
