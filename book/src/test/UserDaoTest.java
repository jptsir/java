package test;

import Dao.UserDao;
import org.junit.Test;
import Dao.UserDaoImpl;

/**
 * @author jingpengtao
 * @create 2021-09-24 20:33
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void forname() {
        if (userDao.forname("12345") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void fornamepass() {
        if ( userDao.fornamepass("123456","123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }


}