package design.pattern.decorator.role;

import design.pattern.decorator.Component;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-17
 **/
public abstract class GameObjectDecorator implements Component {

    private Component component;

    public GameObjectDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void show() {
        component.show();
        addDecorator();
    }

    public abstract void addDecorator();
}

