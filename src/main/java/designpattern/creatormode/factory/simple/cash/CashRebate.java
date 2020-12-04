package designpattern.creatormode.factory.simple.cash;

public class CashRebate extends CashSuper {
    public double rebate;

    public CashRebate(double rebate){
        this.rebate = rebate;
    }

    public double takeMoney(double money) {
        return money * rebate;
    }
}
