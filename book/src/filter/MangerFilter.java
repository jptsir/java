package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jingpengtao
 * @create 2021-10-06 14:56
 */
public class MangerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("loginUser");
        if(user==null){
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(httpServletRequest,servletResponse);

        }else{
            filterChain.doFilter(httpServletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
