package spring;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class MyBeanFactory {

    public static CustomerDao getBean(){
        final CustomerDao customerDao = new CustomerDaoImpl();
        final MyAspect myAspect = new MyAspect();

        return (CustomerDao) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), new Class[]{CustomerDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        myAspect.myBefore();
                        Object o1 = method.invoke(customerDao,objects);
                        myAspect.myAfter();
                        return o1;
                    }
                });

    }
    @Test
    public void test() {
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
        customerDao.delete();
        customerDao.find();
        customerDao.update();
        char[] s = new char[1];
        s[0] = 1;
    }

    @Test
    public void toBinaryStr(){
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        String s = "1e3d";
        System.out.println(Double.parseDouble(s));
    }

}
