package com.learn.designpattern.creatormode.factory.simple.cal;

public class Operation {
    public double _numberA = 0;
    public double _numberB = 0;

    public double GetResult() {
        return 0;
    }

    /**
     * 获取
     *
     * @return _numberA
     */
    public double get_numberA() {
        return this._numberA;
    }

    /**
     * 设置
     *
     * @param _numberA
     */
    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    /**
     * 获取
     *
     * @return _numberB
     */
    public double get_numberB() {
        return this._numberB;
    }

    /**
     * 设置
     *
     * @param _numberB
     */
    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }
}
