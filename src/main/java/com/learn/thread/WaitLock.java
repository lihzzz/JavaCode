package com.learn.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitLock {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(()->{
            System.out.println("before wait1 ...");

            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
//            synchronized (obj){
//                try {
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println("after wait1 ...");
        });

        Thread thread2 = new Thread(()->{
            System.out.println("before wait2 ...");
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println("after wait2 ...");
        });
        thread1.start();
        thread2.start();

        Thread.sleep(1);
        lock.lock();
        condition.signalAll();
        lock.unlock();
//        synchronized (obj){
//            obj.notifyAll();
//        }
    }
}
