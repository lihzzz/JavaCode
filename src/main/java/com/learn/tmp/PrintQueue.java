package com.learn.tmp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Lock lock = new ReentrantLock();

    public void printJob(Object document){
        lock.lock();

        try {
            Long duration = (long) (Math.random() * 5000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
                    Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
//        lock.lock();
//        try {
//            Long duration = (long) (Math.random() * 10000);
//            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
//                    Thread.currentThread().getName(), (duration / 1000));
//            Thread.sleep(duration);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue),"Thread-" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
            Thread.sleep(100);
        }
    }
}
