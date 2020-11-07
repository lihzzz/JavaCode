package designpattern.factory.simple.cash;

public class CashNormal extends CashSuper {

    public CashNormal(){
    }

    public double takeMoney(double money) {
        return money;
    }
}
