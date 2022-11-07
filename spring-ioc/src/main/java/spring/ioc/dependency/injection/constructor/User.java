package spring.ioc.dependency.injection.constructor;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spring.ioc.dependency.injection.setter.Movie;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-06
 **/
@Component("user")
public class User {

    @Value(value = "搁浅")
    private String name;

    @Value(value = "19")
    private Integer age;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

