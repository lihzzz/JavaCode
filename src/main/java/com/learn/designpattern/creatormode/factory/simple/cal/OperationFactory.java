package com.learn.designpattern.creatormode.factory.simple.cal;

/**
 * @author lh
 * Created on 2020/11/7
 */
public class OperationFactory {
    public static Operation createOperate(String operate){
        Operation operation = null;
        if ("+".equals(operate)) {
            return new OperationAdd();
        } else if ("-".equals(operate)) {
            return new OperationSub();
        } else if ("*".equals(operate)) {
            return new OperationMul();
        } else if ("/".equals(operate)) {
            return new OperationDiv();
        }
        return null;
    }
}
