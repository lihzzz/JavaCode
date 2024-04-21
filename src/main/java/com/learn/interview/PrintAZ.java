package com.learn.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAZ {

    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long mainStart = System.currentTimeMillis();
        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                reentrantLock.lock();
                for (char i = 'a'; i <= 'z'; i++) {
                    if (PrintAZ.state == 1) {
                        conditionA.await();
                    }
                    System.out.println(i);
                    PrintAZ.state = 1;
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            long time = System.currentTimeMillis() - start;
            System.out.println(Thread.currentThread().getName() + " time: " + time);
            countDownLatch.countDown();
        }, "ThreadA").start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(1000); // 时间太短增加时间
                reentrantLock.lock();
                for (char i = 'A'; i <= 'Z'; i++) {
                    if (PrintAZ.state == 0) {
                        conditionB.await();
                    }
                    PrintAZ.state = 0;
                    System.out.println(i);
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            long time = System.currentTimeMillis() - start;
            System.out.println(Thread.currentThread().getName() + " time: " + time);
            countDownLatch.countDown();

        }, "ThreadB").start();


        countDownLatch.await();
        long mainEnd = System.currentTimeMillis() - mainStart;
        System.out.println(Thread.currentThread().getName() + "time: " + mainEnd);


    }

}
