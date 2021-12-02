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
import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-02 19:01
 */
public class BookServlet extends BaseServlet{
    private BookServes bookserves = new BookServesImpl();
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pageNo = req.getParameter("pageNo");
//        String pageSize = req.getParameter("pageSize");
//
//        //1 获取请求的参数 pageNo 和 pageSize
//        int parser = WebUtils.parser(pageNo, 1);
//        int parser1 = WebUtils.parser(pageSize, Page.PAGE_SIZE);
//        //int pageNo = WebUtils.parser(req.getParameter("pageNo"), 1);
//       // int pageSize = WebUtils.parser(req.getParameter("pageSize"), Page.PAGE_SIZE);//1 获取请求的参数 pageNo 和 pageSize
//
//        Page<Book> page = bookserves.page(parser, parser1);
        int pageNo = WebUtils.parser(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parser(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookserves.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamtoBean(req.getParameterMap(), new Book());
        bookserves.addBook(book);

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));


    }  public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parser = WebUtils.parser(id, 0);
        bookserves.deleteBookById(parser);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));


    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamtoBean(req.getParameterMap(), new Book());
        bookserves.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));


    }
    public void getBok(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parser = WebUtils.parser(id, 0);
        Book book = bookserves.queryBookById(parser);
        req.setAttribute("books",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);


    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有书
        List<Book> books = bookserves.queryBooks();
        //保存于request域中
        req.setAttribute("books",books);
        //请求转发到/manager/book_manager
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }


}
