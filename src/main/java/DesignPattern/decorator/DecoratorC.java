package DesignPattern.decorator;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/9
 */
public class DecoratorC extends Decorator{
    private String name;

    @Override
    public void Operation() {
        super.Operation();
        name = "DecoratorC--";
        System.out.println(name);
    }

}
