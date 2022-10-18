package com.learn.designpattern.creatormode.factory.di.context;

import com.learn.designpattern.creatormode.factory.di.BeansFactory;
import com.learn.designpattern.creatormode.factory.di.context.ApplicationContext;
import com.learn.designpattern.creatormode.factory.di.parse.BeanConfigParser;
import com.learn.designpattern.creatormode.factory.di.parse.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:36
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return null;
    }
}
