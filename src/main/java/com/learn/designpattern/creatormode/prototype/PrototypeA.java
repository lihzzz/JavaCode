package com.learn.designpattern.creatormode.prototype;

/**
 * @author lh
 * Created on 2020/11/12
 */
public class PrototypeA implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
