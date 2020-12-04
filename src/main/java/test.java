import DesignPattern.Creator.builder.Car;
import DesignPattern.Creator.builder.CarBuilder;

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

//        DecoratorA decoratorA = new DecoratorA();
//        DecoratorB decoratorB = new DecoratorB();
//        DecoratorC decoratorC = new DecoratorC();
//
//        decoratorB.SetComponent(decoratorA);
//        decoratorC.SetComponent(decoratorB);
//        decoratorC.Operation();

//        GiftProxy giftProxy = new GiftProxy(new SchoolGirl("lalala"));
//        giftProxy.giveGiftOne();
//        giftProxy.giveGiftTwo();
//        giftProxy.giveGiftThree();

        // 建造者模式
        Car car = new CarBuilder().type("小").comfort("一般舒适").power("动力强劲").build();
        System.out.println(car.toString());
    }
}
