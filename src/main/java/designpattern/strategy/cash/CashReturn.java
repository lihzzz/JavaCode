//package designpattern.strategy.cash;
//
//public class CashReturn extends CashStrategy {
//
//    public int condition;
//    public int returnMoney;
//
//    public CashReturn(int condition,int returnMoney){
//        this.condition = condition;
//        this.returnMoney = returnMoney;
//    }
//
//    @Override
//    public double takeMoney(double money) {
//
//        return money - Math.floor(money / condition) * returnMoney;
//    }
//}
