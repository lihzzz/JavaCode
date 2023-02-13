package com.learn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersSample implements Runnable{

    int forks[] = new int[5];
    Phi[] phis = new Phi[5];
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean[] dirty = new boolean[5];
    public DiningPhilosophersSample(){
        for (int i = 0; i < 5; i++) {
            phis[i] = new Phi(i+1);
        }
    }
    class Phi extends Philosopher{

        public Phi(int id) {
            super(id);
        }

        @Override
        public void run() {
            while (true){
                try {
                    this.thinking();
                    lock.lockInterruptibly();
//                    while(!(this.checkLeft(forks) && this.checkRight(forks))){
//                        condition.await();
//                    }

//                    while(!this.takeLeft(forks)){
//                        condition.await();
//                    }
//                    while (!this.takeRight(forks)){
//                        condition.await();
//                    }
                    boolean takeLeft = this.checkLeft(forks);
                    if(!takeLeft){
                        lock.unlock();
                        continue;
                    }
                    this.takeLeft(forks);
                    boolean takeRight = this.checkRight(forks);
                    if(takeRight){
                        this.takeRight(forks);
                    }else{
                        int rid = this.right();
                        Phi phi = phis[forks[rid] - 1];
                        if(dirty[rid] == true && phi.getState() != "eating"){
                            forks[rid] = this.id;
                            this.takeRight(forks);
                            dirty[rid] = false;
                        }else{
                            lock.unlock();
                            continue;
                        }
                    }
                    lock.unlock();
                    this.eating();

                    lock.lockInterruptibly();
                    this.putLeft(forks);
                    this.putRight(forks);
                    dirty[this.left()] = true;
                    dirty[this.right()] = true;
                    lock.unlock();

                    this.finished();
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < phis.length; i++) {
            new Thread(phis[i]).start();
        }
    }

    public static void main(String[] args) {
        DiningPhilosophersSample diningPhilosophersSample = new DiningPhilosophersSample();
        diningPhilosophersSample.run();
    }
}
