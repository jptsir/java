package Dao;

import pojo.User;

/**
 * @author jingpengtao
 * @create 2021-09-23 20:45
 */
public interface UserDao {

    public User forname(String username);
       /* String sql = "select username from t_user where username=?";
        t_user querone = BaseDao.querone(t_user.class, sql, username);
        return querone;*/


    public User fornamepass(String username, String password);


    public int saver(User user);
}
