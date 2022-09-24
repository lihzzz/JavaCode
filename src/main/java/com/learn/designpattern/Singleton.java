package com.learn.designpattern;

/**
 * 单例设计模式
 * 1.解决资源访问冲突
 * 2.表示全局唯一类：配置信息类、递增ID号码生成器
 */
public class Singleton {

    public static volatile Singleton singleton;

    private Singleton(){};

    /**
     * 懒汉单例
     * @return
     */
    public static Singleton getSingleton() {
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }

}
