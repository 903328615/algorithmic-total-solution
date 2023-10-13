package design.pattern.proxy.autoproxy;

import design.pattern.proxy.staticproxy.BookDAO;
import design.pattern.proxy.staticproxy.BookDaoImpl;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class Main {
    public static void main(String[] args) {

        BookDaoImpl bookDaoImpl = new BookDaoImpl();
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        BookDAO bookDAO = (BookDAO) Proxy.newProxyInstance(BookDAO.class.getClassLoader(),
                new Class[]{BookDAO.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        Object o = method.invoke(bookDaoImpl, args);
                        long end = System.currentTimeMillis();
                        System.out.println("耗时：" + (end - start) + "毫秒");
                        return o;
                    }
                });
        bookDAO.listAllBook();
    }
}

