package com.learn.designpattern;

/**
 * 单例设计模式
 * 1.解决资源访问冲突
 * 2.表示全局唯一类：配置信息类、递增ID号码生成器
 */
public class Singleton {

    /**
     * 懒汉式 -- 锁导致并发度降低
     */
    public static volatile Singleton lazySingleton;

    /**
     * 饿汉式 -- 提前创建好实例，占用资源，无法延迟加载
     */
    public static final Singleton hungrySingleton = new Singleton();

    /**
     * 静态内部类 -- jvm保证线程安全
     */
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    /**
     * 枚举单例
     */
    private enum EnumSingleton {
        INSTANCE;
        private final Singleton singleton;

        EnumSingleton() {
            singleton = new Singleton();
        }

        private Singleton getInstance() {
            return singleton;
        }
    }

    /**
     * 构造private，防止外部通过new创建实例
     */
    private Singleton() {
    }

    ;

    /**
     * 懒汉单例
     *
     * @return
     */
    public static Singleton getSingleton() {
        if (lazySingleton == null) {
            // 懒汉初始化加锁操作，解决并发问题
            synchronized (Singleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new Singleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }

}
