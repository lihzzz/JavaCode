package com.learn.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinPin {
    public volatile int LipinCount = 1000;
    public int MAX_COUNT = 1000;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition consumerCondition = reentrantLock.newCondition();
    Condition producerCondition = reentrantLock.newCondition();

    public int maxCount = 3;

    public void start(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                int count = 0;
                while(true){
                    reentrantLock.lock();
                    if(LipinCount < 0){
                        try {
                            consumerCondition.await();
                            producerCondition.signalAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    LipinCount--;
                    count++;
                    reentrantLock.unlock();
                    if(count >= maxCount){
                        break;
                    }
                }
            }).start();
        }
    }

    public void producer(){
        // 生产物品
        new Thread(()->{
            while(true){
                reentrantLock.lock();
                if(LipinCount == MAX_COUNT){
                    try {
                        producerCondition.await();
                        consumerCondition.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                LipinCount++;
                reentrantLock.unlock();
            }
        }).start();

    }

}
