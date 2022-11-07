package design.pattern.proxy.staticproxy;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class BookDaoLogProxy implements BookDAO {

    BookDAO bookDAO;


    public BookDaoLogProxy(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void listAllBook() {
        System.out.println("方法执行开始");
        bookDAO.listAllBook();
        System.out.println("方法执行结束");
    }

}

