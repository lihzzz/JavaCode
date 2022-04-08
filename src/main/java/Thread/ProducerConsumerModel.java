package Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerModel {
    public static int max = 10;
    public Queue<Integer> queue = new LinkedList<>();

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition full = reentrantLock.newCondition();
    Condition empty = reentrantLock.newCondition();

    public  void consumeData() throws InterruptedException {
        reentrantLock.lock();
        if(queue.isEmpty()){
            empty.await();
            return;
        }
        int num = queue.poll();
        num *= 2;
        if(queue.size() == 0){
            full.signalAll();
        }
        System.out.println("consumerData size: " + queue.size());
        reentrantLock.unlock();
    }

    public int getData() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return (int) Math.floor(Math.random() * 1000);
    }

    public void produceData() throws InterruptedException {
        reentrantLock.lock();
        if(queue.size() == max){
            full.await();
            return;
        }
        int data = getData();
        queue.offer(data);
        if(queue.size() == 1){
            empty.signalAll();
        }
        System.out.println("produceData size: " + queue.size());
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        ProducerConsumerModel producerConsumerModel = new ProducerConsumerModel();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    try {
                        producerConsumerModel.produceData();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true){
                    try {
                        producerConsumerModel.consumeData();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
