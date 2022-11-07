package spring.ioc.dependency.injection.setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.ioc.dependency.injection.constructor.User;

import javax.annotation.Resource;


/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-07
 **/
@Repository("movie")
public class Movie {

    @Value(value = "天下")
    private String name;

    @Resource
    private User user;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}

