package DesignPattern.Creator.factory.simple.cash;

public class CashNormal extends CashSuper {

    public CashNormal(){
    }

    @Override
    public double takeMoney(double money) {
        return money;
    }
}
