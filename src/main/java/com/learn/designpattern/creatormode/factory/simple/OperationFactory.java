package com.learn.designpattern.creatormode.factory.simple;

import com.learn.designpattern.creatormode.factory.IFactory;
import com.learn.designpattern.creatormode.factory.simple.cal.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 简单工厂创建方法
 *
 * @author lh
 * Created on 2020/11/7
 */
public class OperationFactory {

    /**
     * 创建方式一
     *
     * @param operate
     * @return
     */
    public static Operation createOperate(String operate) {
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


    private static final Map<String, Operation> cacheOperate = new HashMap<>();

    static {
        cacheOperate.put("+", new OperationAdd());
        cacheOperate.put("-", new OperationSub());
        cacheOperate.put("*", new OperationMul());
        cacheOperate.put("/", new OperationDiv());
    }

    /**
     * 简单工厂创建方式2
     *
     * @param operate
     * @return
     */
    public static Operation getOperater(String operate) {
        if (StringUtils.isBlank(operate)) {
            return null;
        }
        return cacheOperate.get(operate.toLowerCase(Locale.ROOT));
    }

}
