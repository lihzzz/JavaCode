package com.learn.designpattern.creatormode.factory.simple.cash;

public class CashNormal extends Cash {

    @Override
    public double takeMoney(double money) {
        return money;
    }
}
