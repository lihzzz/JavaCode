package com.learn.designpattern.creatormode.factory;

import com.learn.designpattern.creatormode.factory.simple.cal.Operation;

/**
 * 工厂创建接口
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/12
 */
public interface IFactory {
    Operation createOperation();
}
