package design.pattern.decorator;


import design.pattern.decorator.clothes.Clothes86Decorator;
import design.pattern.decorator.clothes.ClothesHellfireDecorator;
import design.pattern.decorator.role.GameObject;
import design.pattern.decorator.role.Human;
import design.pattern.decorator.role.WuKong;
import design.pattern.decorator.trail.AdventureTrailDecorator;
import design.pattern.decorator.trail.TrailDecorator;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-17
 **/
public class Main {

    public static void main(String[] args) {

        GameObject wuKong=new WuKong();
        wuKong.show();
        System.out.println();

        Clothes86Decorator clothes86Decorator=new Clothes86Decorator(wuKong);
        TrailDecorator trailDecorator=new TrailDecorator(clothes86Decorator);
        trailDecorator.show();
        System.out.println();

        ClothesHellfireDecorator clothesHellfireDecorator=new ClothesHellfireDecorator(wuKong);
        AdventureTrailDecorator adventureTrailDecorator=new AdventureTrailDecorator(clothesHellfireDecorator);
        adventureTrailDecorator.show();
        System.out.println();

        Human human=new Human();
        ClothesHellfireDecorator clothesHellfireDecorator2=new ClothesHellfireDecorator(human);
        AdventureTrailDecorator adventureTrailDecorator2=new AdventureTrailDecorator(clothesHellfireDecorator2);
        adventureTrailDecorator2.show();
        System.out.println();

        wuKong.show();
    }
}

