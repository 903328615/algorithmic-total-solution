package design.pattern.decorator.trail;

import design.pattern.decorator.Component;
import design.pattern.decorator.role.GameObject;
import design.pattern.decorator.role.GameObjectDecorator;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-17
 **/
public class AdventureTrailDecorator extends GameObjectDecorator {

    public AdventureTrailDecorator(Component component) {
        super(component);
    }

    @Override
    public void addDecorator() {
        System.out.println("装备 冒险拖尾");
    }
}

