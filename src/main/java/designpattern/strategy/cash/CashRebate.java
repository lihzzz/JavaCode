package designpattern.strategy.cash;

public class CashRebate extends CashStrategy {
    public double rebate;

    public CashRebate(double rebate){
        this.rebate = rebate;
    }

    @Override
    public double takeMoney(double money) {
        return money * rebate;
    }
}
