package design.pattern.proxy.autoproxy;

import design.pattern.proxy.staticproxy.BookDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-24
 **/
public class CglibMain {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(BookDaoImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object result = methodProxy.invokeSuper(o, objects);
                long end = System.currentTimeMillis();
                System.out.println("耗时：" + (end - start) + "毫秒");
                return result;
            }
        });
        BookDaoImpl bookDao= (BookDaoImpl) enhancer.create();
        bookDao.listAllBook();
    }
}

