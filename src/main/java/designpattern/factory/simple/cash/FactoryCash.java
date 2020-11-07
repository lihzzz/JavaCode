package designpattern.factory.simple.cash;

public class FactoryCash {
    public static CashSuper cashFactory(String type){
        switch (type){
            case "正常收费":
                return new CashNormal();
            case "满300返100":
                return new CashReturn(300,100);
            case "打8折":
                return new CashRebate(0.8);
            default:
                return new CashNormal();
        }
    }
}
