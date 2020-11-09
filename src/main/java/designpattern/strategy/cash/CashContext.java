package designpattern.strategy.cash;

public class CashContext {
    CashSuper cashStrategy;
    public CashContext(CashSuper cashStrategy){
        this.cashStrategy = cashStrategy;
    }

    public void ContextInterface(double money){
        cashStrategy.takeMoney(money);
    }
}
