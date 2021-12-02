package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-02 15:56
 */
public interface BookServes {
    //增加
    public void addBook(Book book);
    //删除
    public void deleteBookById(Integer id);
    //修改
    public void updateBook(Book book);
    //查询一条记录
    public Book queryBookById(Integer id);
    //查询多条记录
    public List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);


    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
