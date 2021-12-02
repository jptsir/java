package Dao;

import pojo.User;

/**
 * @author jingpengtao
 * @create 2021-09-23 20:47
 */
public class UserDaoImpl extends BaseDao implements UserDao {

//按名字查询
    @Override
    public User forname(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";
        return BaseDao.querone(User.class, sql, username);


    }
    //按name和password查询
    @Override
    public User fornamepass(String username, String password) {
        String sql ="select `id`,`username`,`password`,`email` from t_user where username =? and password =?";
        return  BaseDao.querone(User.class, sql,username,password);

    }
//保存
    @Override
    public int saver(User user) {
    String sql = "insert into t_user(username,password,email) values(?,?,?)";
        int crud = BaseDao.crud(sql, user.getUsername(), user.getPassword(), user.getEmail());
        if(crud>0){
            System.out.println("保存成功");
        }
        return -1;
    }
}
