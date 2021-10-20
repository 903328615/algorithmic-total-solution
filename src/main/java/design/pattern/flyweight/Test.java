package design.pattern.flyweight;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-09-27
 **/
public class Test {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory=new FlyweightFactory();

        flyweightFactory.getFlyweight("黑棋").process(new UnFlyweight("天元"));
        flyweightFactory.getFlyweight("白棋").process(new UnFlyweight("地方"));
        flyweightFactory.getFlyweight("白棋").process(new UnFlyweight("未知"));
        flyweightFactory.getFlyweight("白棋").process(new UnFlyweight("星光"));
        flyweightFactory.getFlyweight("黑棋").process(new UnFlyweight("山海"));

    }
}

