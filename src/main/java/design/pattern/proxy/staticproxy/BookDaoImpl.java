package design.pattern.proxy.staticproxy;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class BookDaoImpl implements BookDAO{
    @Override
    public void listAllBook() {
        System.out.println("模拟查询列出所有书籍");
        try {
            Thread.sleep((long) (Math.random()*1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

