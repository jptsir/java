package web;

import pojo.User;
import service.userserveImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jingpengtao
 * @create 2021-09-25 10:49
 */
public class LoginServlet extends HttpServlet {
    private userserveImpl userService = new userserveImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
// 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
// 如果等于 null,说明登录 失败!
        if (loginUser == null) {
// 跳回登录页面
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
// 登录 成功
//跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}
