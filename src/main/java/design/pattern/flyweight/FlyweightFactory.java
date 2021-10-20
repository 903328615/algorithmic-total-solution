package design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-09-27
 **/
public class FlyweightFactory {

    private final Map<String, FlyweightImpl> cache = new HashMap<>();

    public FlyweightImpl getFlyweight(String key) {
        if (cache.containsKey(key)) {
            System.out.println(key + " 已存在直接使用 ");
            return cache.get(key);
        } else {
            System.out.println("创建 " + key);
            FlyweightImpl flyweight = new FlyweightImpl(key);
            cache.put(key, flyweight);
            return flyweight;
        }
    }

}

