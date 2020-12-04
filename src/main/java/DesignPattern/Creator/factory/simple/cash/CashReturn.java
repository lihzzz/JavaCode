package DesignPattern.Creator.factory.simple.cash;

public class CashReturn extends CashSuper{

    public int condition;
    public int returnMoney;

    public CashReturn(int condition,int returnMoney){
        this.condition = condition;
        this.returnMoney = returnMoney;
    }

    public double takeMoney(double money) {

        return money - Math.floor(money / condition) * returnMoney;
    }
}
