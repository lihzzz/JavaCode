import designpattern.decorator.Decorator;
import designpattern.decorator.DecoratorA;
import designpattern.decorator.DecoratorB;
import designpattern.decorator.DecoratorC;
import designpattern.factory.simple.cal.Operation;
import designpattern.factory.simple.cal.OperationFactory;
import designpattern.factory.simple.cash.CashSuper;
import designpattern.factory.simple.cash.FactoryCash;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/7
 */
public class test {
    public static void main(String[] args) {
//        Operation operation = OperationFactory.createOperate("/");
//        operation.set_numberA(4);
//        operation.set_numberB(2);
//        System.out.println(operation.GetResult());
//        CashSuper cashSuper = FactoryCash.cashFactory("满300返100");
//        System.out.println(cashSuper.takeMoney(700));

        DecoratorA decoratorA = new DecoratorA();
        DecoratorB decoratorB = new DecoratorB();
        DecoratorC decoratorC = new DecoratorC();

        decoratorB.SetComponent(decoratorA);
        decoratorC.SetComponent(decoratorB);
        decoratorC.Operation();

    }
}
