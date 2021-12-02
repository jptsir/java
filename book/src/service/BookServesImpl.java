package service;

import Dao.BookDao;
import Dao.BookDaoImpl;
import pojo.Book;
import pojo.Page;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-02 15:58
 */
public class BookServesImpl implements BookServes{
    private BookDao bookdao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        int i = bookdao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
       bookdao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
       bookdao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookdao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookdao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
// 设置当前页码
        page.setPageNo(pageNo);
// 设置每页显示的数量
        page.setPageSize(pageSize);
// 求总记录数
        Integer pageTotalCount = bookdao.queryForPageTotalCount();
// 设置总记录数
        page.setPageTotalCount(pageTotalCount);
// 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
// 设置总页码
        page.setPageTotal(pageTotal);
// 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
// 求当前页数据
        List<Book> items = bookdao.queryForPageItems(begin,pageSize);
// 设置当前页数据
        page.setItem(items);
        return page;

    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookdao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据

        List<Book> items = bookdao.queryForPageItemsByPrice(begin,pageSize,min,max);        // 设置当前页数据
        page.setItem(items);

        return page;
    }
}

