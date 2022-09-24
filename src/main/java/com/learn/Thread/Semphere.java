package com.learn.Thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Semphere extends AbstractQueuedSynchronizer {

    public Semphere(int state){
        setState(state);
    }


    @Override
    protected int tryAcquireShared(int arg) {
        int available = getState();
        if(available == 0){
            return -1;
        }
        int left = available - 1;
        if(compareAndSetState(available,left)){
            return left;
        }
        return -1;
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        int available = getState();
        return compareAndSetState(available,available+1);
    }

    public static void main(String[] args) {
        Semphere semphere = new Semphere(4);

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                semphere.acquireShared(0);
                System.out.println("go");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semphere.releaseShared(0);
            }).start();
        }
    }
}
