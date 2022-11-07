package design.pattern.proxy.staticproxy;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO=new BookDaoImpl();
        BookDaoTimeProxy bookDaoTimeProxy=new BookDaoTimeProxy(bookDAO);
        BookDaoLogProxy bookDaoLogProxy=new BookDaoLogProxy(bookDaoTimeProxy);
        bookDaoLogProxy.listAllBook();
    }
}

