package com.learn.designpattern.creatormode.factory.di;

import com.learn.designpattern.creatormode.factory.di.parse.ConstructorArg;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean创建工厂类
 *
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:38
 */
public class BeansFactory {

    /**
     * 单例对象map
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 对象map
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    /**
     * 根据配置创建bean
     *
     * @param beanDefinition
     * @return
     */
    public Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            // 单例对象 && 已经初始化过的对象不在进行初始化，直接返回
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;
        try {
            // 根据类名获取class对象
            Class<?> beanClass = Class.forName(beanDefinition.getClassName());
            // 获取bean构造函数参数
            List<ConstructorArg> args = beanDefinition.getConstructorArgs();
            if (args.isEmpty()) {
                // 构造函数不需要参数
                return beanClass.newInstance();
            }
            // 参数class数组
            Class<?>[] argClass = new Class[args.size()];
            // 参数object数组
            Object[] argObject = new Object[args.size()];
            for (int i = 0; i < args.size(); i++) {
                ConstructorArg arg = args.get(0);
                if (!arg.isIsRef()) {
                    // 非引用参数
                    argClass[i] = arg.getType();
                    argObject[i] = arg.getArg();
                } else {
                    // 需要注入参数
                    BeanDefinition refDefinition = beanDefinitions.get(beanDefinition.getId());
                    if (refDefinition == null) {
                        throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                    }
                    argClass[i] = Class.forName(refDefinition.getClassName());
                    argObject[i] = createBean(refDefinition);
                }
            }

            bean = beanClass.getConstructor(argClass).newInstance(argObject);
        } catch (Exception e) {

        }
        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }

    /**
     * 获取bean
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }
}
