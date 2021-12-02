package Dao;

import pojo.Book;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-01 21:18
 */
public interface BookDao {
    //增加
    public int addBook(Book book);
//删除
    public int deleteBookById(Integer id);
//修改
    public int updateBook(Book book);
//查询一条记录
    public Book queryBookById(Integer id);
//查询多条记录
    public List<Book> queryBooks();
public Integer queryForPageTotalCount();
public  List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
