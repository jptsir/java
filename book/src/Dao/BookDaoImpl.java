package Dao;

import pojo.Book;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-10-01 21:30
 */
public class BookDaoImpl extends BaseDao implements BookDao{

    @Override
    public int addBook(Book book) {
      String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
      return crud(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return crud(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? where id = ?";
        return crud(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
       String sql = "select id, `name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book where id = ?";
       return querone(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
       String sql = "select id, `name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book";
       return querm(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql ="select count(*) from t_book";
        Number count = (Number) quermt(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return querm(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) quermt(sql,min,max);
        return count.intValue();
    }



    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath " +
                "from t_book where price between ? and ? order by price limit ?,?";
        return querm(Book.class,sql,min,max,begin,pageSize);
    }


}
