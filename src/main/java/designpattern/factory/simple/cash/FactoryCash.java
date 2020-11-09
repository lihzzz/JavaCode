package designpattern.factory.simple.cash;

/**
 * @author lh
 * 将不同的变化封装到不同的类中，然后用统一的工厂类创建相应变化的类
 */
public class FactoryCash {
    public static CashSuper cashFactory(String type){
        switch (type){
            case "满300返100":
                return new CashReturn(300,100);
            case "打8折":
                return new CashRebate(0.8);
            default:
                return new CashNormal();
        }
    }
}
