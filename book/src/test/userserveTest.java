package test;

import org.junit.Test;
import pojo.User;
import service.userserveImpl;

/**
 * @author jingpengtao
 * @create 2021-09-24 20:47
 */
public class userserveTest {
    userserveImpl userService = new userserveImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "bbj168", "666666", "bbj168@qq.com")) );
    }

    @Test
    public void check() {
        if (userService.check("qwerr")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}