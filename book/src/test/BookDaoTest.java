package test;

import Dao.BookDao;
import Dao.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-01 21:59
 */
public class BookDaoTest {
BookDao bookdao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookdao.addBook(new Book(null,"国哥为什么这么帅！", "191125", new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookdao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookdao.updateBook(new Book(21,"大家都可以这么帅！", "国哥", new BigDecimal(9999),1100000,0,null
        ));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookdao.queryBookById(21) );
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookdao.queryBooks();
        System.out.println(books);
    }
}