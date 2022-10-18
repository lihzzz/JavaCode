package com.learn.designpattern.creatormode.factory.simple;

import com.learn.designpattern.creatormode.factory.simple.cash.Cash;
import com.learn.designpattern.creatormode.factory.simple.cash.CashNormal;
import com.learn.designpattern.creatormode.factory.simple.cash.CashRebate;
import com.learn.designpattern.creatormode.factory.simple.cash.CashReturn;

/**
 * @author lh
 * 将不同的变化封装到不同的类中，然后用统一的工厂类创建相应变化的类
 */
public class CashFactory {
    public static Cash cashFactory(String type) {
        switch (type) {
            case "满300返100":
                return new CashReturn(300, 100);
            case "打8折":
                return new CashRebate(0.8);
            default:
                return new CashNormal();
        }
    }
}
