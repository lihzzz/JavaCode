package com.learn.designpattern.decorator;

/**
 * @author lh
 * Created on 2020/11/9
 */
public class DecoratorA extends Decorator {

    private String name;

    @Override
    public void Operation() {
        super.Operation();
        name = "DecoratorA--";
        System.out.println(name);
    }
}
