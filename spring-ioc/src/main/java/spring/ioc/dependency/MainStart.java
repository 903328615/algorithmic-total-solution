package spring.ioc.dependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.dependency.injection.constructor.User;
import spring.ioc.dependency.injection.setter.Movie;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;


/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-06
 **/
@ComponentScan("spring.ioc.dependency.injection")
public class MainStart {
    public static void main(String[] args) {
    /*    BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/MATE-INF/dependency-injection-construcor.xml");
*/
        BeanFactory beanFactory=new AnnotationConfigApplicationContext("spring.ioc.dependency.injection");
        User user = (User) beanFactory.getBean("user");
        Movie movie= (Movie) beanFactory.getBean("movie");
        System.out.println(user);
        System.out.println(movie);
    }
}

