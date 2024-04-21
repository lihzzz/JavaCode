package com.learn.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int threadCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " start");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " end");
                    System.out.println(Thread.currentThread().getName() + " start2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " end2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, "thread: " + i);
            thread.start();
        }
    }
}
