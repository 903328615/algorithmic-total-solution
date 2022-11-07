package design.pattern.proxy.staticproxy;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class BookDaoTimeProxy implements BookDAO {

    BookDAO bookDAO;


    public BookDaoTimeProxy(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void listAllBook() {
        long start = System.currentTimeMillis();
        bookDAO.listAllBook();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");
    }

}

