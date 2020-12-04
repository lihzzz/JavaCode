package DesignPattern.decorator;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/9
 */
public class DecoratorB extends Decorator{
    private String name;

    @Override
    public void Operation() {
        super.Operation();
        name = "DecoratorB--";
        System.out.println(name);
    }
}
