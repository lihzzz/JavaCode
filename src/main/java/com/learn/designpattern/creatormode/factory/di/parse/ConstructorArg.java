package com.learn.designpattern.creatormode.factory.di.parse;

/**
 * 构造参数类型
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:40
 */
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    /**
     * 获取
     *
     * @return isRef
     */
    public boolean isIsRef() {
        return this.isRef;
    }

    /**
     * 设置
     *
     * @param isRef
     */
    public void setIsRef(boolean isRef) {
        this.isRef = isRef;
    }

    /**
     * 获取
     *
     * @return type
     */
    public Class getType() {
        return this.type;
    }

    /**
     * 设置
     *
     * @param type
     */
    public void setType(Class type) {
        this.type = type;
    }

    /**
     * 获取
     *
     * @return arg
     */
    public Object getArg() {
        return this.arg;
    }

    /**
     * 设置
     *
     * @param arg
     */
    public void setArg(Object arg) {
        this.arg = arg;
    }
}
