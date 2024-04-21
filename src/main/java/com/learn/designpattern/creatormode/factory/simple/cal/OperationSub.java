package com.learn.designpattern.creatormode.factory.simple.cal;

/**
 * @author lh
 * Created on 2020/11/7
 */
public class OperationSub extends Operation {

    @Override
    public double GetResult() {
        return this._numberA - this._numberB;
    }
}
