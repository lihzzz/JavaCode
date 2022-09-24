package com.learn.designpattern.decorator;

/**
 * @author lh
 * Created on 2020/11/9
 * 在不同的情况下需要表现出不同的行为，可以把共同的方法抽象出来，让子类实现不同的行为
 *
 *
 */
public class Decorator extends Component{
    protected Component component;

    public void SetComponent(Component component){
        this.component = component;
    }

    @Override
    public void Operation() {
        if(this.component != null){
            this.component.Operation();
        }
    }
}
