package web;

import pojo.Book;
import pojo.Page;
import service.BookServes;
import service.BookServesImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jingpengtao
 * @create 2021-10-03 21:10
 */
public class ClientBookServlet extends BaseServlet {

private BookServes bookserves = new BookServesImpl();
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pageNo = req.getParameter("pageNo");
//        String pageSize = req.getParameter("pageSize");
//
//        //1 获取请求的参数 pageNo 和 pageSize
//        int parser = WebUtils.parser(pageNo, 1);
//        int parser1 = WebUtils.parser(pageSize, Page.PAGE_SIZE);
        //int pageNo = WebUtils.parser(req.getParameter("pageNo"), 1);
        // int pageSize = WebUtils.parser(req.getParameter("pageSize"), Page.PAGE_SIZE);//1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parser(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parser(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookserves.page(pageNo,pageSize);

         page.setUrl("Client/ClientBookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/Client/index.jsp").forward(req, resp);

    }
    public void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        int min = WebUtils.parser(req.getParameter("min"), 0);
        int max = WebUtils.parser(req.getParameter("max"), Integer.MAX_VALUE);

        //1 获取请求的参数 pageNo 和 pageSize
        int parser = WebUtils.parser(pageNo, 1);
        int parser1 = WebUtils.parser(pageSize, Page.PAGE_SIZE);
        //int pageNo = WebUtils.parser(req.getParameter("pageNo"), 1);
        // int pageSize = WebUtils.parser(req.getParameter("pageSize"), Page.PAGE_SIZE);//1 获取请求的参数 pageNo 和 pageSize
        Page<Book> page = bookserves.pageByPrice(parser,parser1,min,max);
        StringBuilder sb = new StringBuilder("Client/ClientBookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }


    }