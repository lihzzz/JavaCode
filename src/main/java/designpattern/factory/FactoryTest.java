package designpattern.factory;

import designpattern.factory.simple.cal.Operation;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public class FactoryTest {
    public static void main(String[] args) {
        IFactory iFactory = new AddFactory();
        Operation operation = iFactory.createOperation();
        operation._numberA = 1;
        operation._numberB = 1000;

        System.out.println(operation.GetResult());
    }
}
