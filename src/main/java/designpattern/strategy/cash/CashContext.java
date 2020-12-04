package designpattern.strategy.cash;

/**
 * @author lh
 * 策略模式封装了变化
 */
public class CashContext {
    CashStrategy cashStrategy;

    /**
     * 简单策略模式
     * @param cashStrategy
     */
    public CashContext(CashStrategy cashStrategy){
        this.cashStrategy = cashStrategy;
    }

    /**
     * 策略模式 + 简单工厂
      * @param type
     */
    public CashContext(String type){
        switch (type){
            case "正常收费":
                this.cashStrategy = new CashNormal();
                break;
            case "打8折":
                this.cashStrategy = new CashRebate(0.8);
                break;
            case "满300减100":
                this.cashStrategy = new CashReturn(300,100);
                break;
        }
    }

    public void contextInterface(double money){
        cashStrategy.takeMoney(money);
    }
}
