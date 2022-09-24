package com.learn.Thread;

import java.util.*;
import java.util.concurrent.Delayed;
import java.util.concurrent.Exchanger;

public class ExchangeDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread thread1 = new Thread(()->{

            String str = new String("thread1");
            System.out.println("thread1 ����ͬ����");

            try {
                String res = exchanger.exchange(str);
                System.out.println("thread1��ȡ��������: " + res);
                System.out.println("thread1 ����");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            System.out.println("thread2 ��ʼ");
            try {
                Thread.sleep(3000);
                String str = "thread2";
                System.out.println("thread2 ����ͬ����");
                String res = exchanger.exchange(str);
                System.out.println("thread2 ��ȡ��������: " + res);
                System.out.println("thread2 ����");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        int value = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) it.next();
            Integer key = entry.getKey();
            Integer a = entry.getValue();
            if(a.equals(value)){
                it.remove();
            }
        }
        thread1.start();
        thread2.start();
    }
}
