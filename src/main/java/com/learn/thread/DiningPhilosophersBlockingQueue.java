package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class DiningPhilosophersBlockingQueue implements Runnable {
    LinkedBlockingQueue<Philosopher> workingQueue;
    LinkedBlockingQueue<Philosopher> managerQueue;
    Philosopher[] phi;
    int[] forks;

    public DiningPhilosophersBlockingQueue() {
        phi = new Philosopher[5];
        forks = new int[5];
        workingQueue = new LinkedBlockingQueue<Philosopher>();
        managerQueue = new LinkedBlockingQueue<Philosopher>();
        for (int i = 0; i < 5; i++) {
            phi[i] = new Philosopher(i + 1);
            managerQueue.offer(phi[i]);
        }
    }


    @Override
    public void run() {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 5; i++) {
            pool.submit(new workerManager());
        }

        pool.submit(new contentManager());
    }

    public static void main(String[] argv) {

        DiningPhilosophersBlockingQueue solver = new DiningPhilosophersBlockingQueue();
        solver.run();
    }


    class workerManager implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Philosopher philosopher = workingQueue.take();
                    if (philosopher.getState() == "Hungry") {
                        philosopher.eating();
                        philosopher.putLeft(forks);
                        philosopher.putRight(forks);
                        philosopher.finished();
                        managerQueue.offer(philosopher);
                    } else if (philosopher.getState() == "Thinking") {
                        philosopher.thinking();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class contentManager implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Philosopher philosopher = managerQueue.take();
                    if (philosopher.checkLeft(forks) && philosopher.checkRight(forks)) {
                        philosopher.takeLeft(forks);
                        philosopher.takeRight(forks);
                        workingQueue.offer(philosopher);
                    } else {
                        managerQueue.offer(philosopher);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
