package com.learn.designpattern.creatormode.factory.di.context;

/**
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:35
 */
public interface ApplicationContext {
    /**
     * 获取bean
     *
     * @param beanId
     * @return
     */
    Object getBean(String beanId);
}
