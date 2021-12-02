package service;

import pojo.User;

/**
 * @author jingpengtao
 * @create 2021-09-23 21:03
 */
public interface userserve {

    //注册
    public  void registUser(User user);
    //登录
    public User login(User user);
    //检查
    public boolean check(String username);
}
