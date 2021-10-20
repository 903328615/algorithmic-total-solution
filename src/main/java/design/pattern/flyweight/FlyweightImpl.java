package design.pattern.flyweight;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-09-27
 **/
public class FlyweightImpl implements Flyweight{

    private String chess;

    @Override
    public void process(UnFlyweight unFlyweight) {
        System.out.println("落子："+this.chess+" 于 "+unFlyweight.getLocation());
    }

    public FlyweightImpl(String chess) {
        this.chess = chess;
    }

    public String getChess() {
        return chess;
    }

    public void setChess(String chess) {
        this.chess = chess;
    }
}

