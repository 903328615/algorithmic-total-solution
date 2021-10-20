package design.pattern.decorator.clothes;

import design.pattern.decorator.Component;
import design.pattern.decorator.role.GameObject;
import design.pattern.decorator.role.GameObjectDecorator;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-17
 **/
public class ClothesHellfireDecorator extends GameObjectDecorator {

    public ClothesHellfireDecorator(Component component) {
        super(component);
    }

    @Override
    public void addDecorator() {
        System.out.println("装备地狱火皮肤");
    }
}

