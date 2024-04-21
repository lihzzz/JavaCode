package com.learn.designpattern.creatormode.factory.simple.cash;

public class CashRebate extends Cash {
    public double rebate;

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    public double takeMoney(double money) {
        return money * rebate;
    }
}
