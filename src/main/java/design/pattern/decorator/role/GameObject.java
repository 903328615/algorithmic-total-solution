package design.pattern.decorator.role;

import design.pattern.decorator.Component;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-10-17
 **/
public abstract class GameObject implements Component{

    String name;

    public GameObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void show() {
        System.out.println("英雄登场："+this.name);
    }
}

