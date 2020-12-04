package DesignPattern.strategy.cash;

/**
 * @author lh
 */
public class CashNormal extends CashStrategy {

    public CashNormal(){
    }

    @Override
    public double takeMoney(double money) {
        return money;
    }
}
