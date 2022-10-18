package com.learn.designpattern.creatormode.factory.di;

import com.learn.designpattern.creatormode.factory.di.parse.ConstructorArg;
import com.learn.designpattern.creatormode.factory.di.parse.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 类型定义
 *
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:39
 */
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    /**
     * 获取
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return className
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * 设置
     *
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取
     *
     * @return constructorArgs
     */
    public List<ConstructorArg> getConstructorArgs() {
        return this.constructorArgs;
    }

    /**
     * 设置
     *
     * @param constructorArgs
     */
    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    /**
     * 获取
     *
     * @return scope
     */
    public Scope getScope() {
        return this.scope;
    }

    /**
     * 设置
     *
     * @param scope
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * 获取
     *
     * @return lazyInit
     */
    public boolean isLazyInit() {
        return this.lazyInit;
    }

    /**
     * 设置
     *
     * @param lazyInit
     */
    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
