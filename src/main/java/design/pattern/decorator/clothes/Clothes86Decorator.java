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
public class Clothes86Decorator extends GameObjectDecorator {

    public Clothes86Decorator(Component component) {
        super(component);
    }

    @Override
    public void addDecorator() {
        System.out.println("装备 86 皮肤");
    }
}

