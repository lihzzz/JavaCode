package com.learn.thread;

import java.io.IOException;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) throws IOException {
        int parties = 3;
        int phases = 4;
        final Phaser phaser = new Phaser(0) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("====== Phase : " + phase + " ======");
                return registeredParties == 0;
            }
        };

        // ʮ��ѡ��
        for (int index = 0; index < 10; index++) {
            phaser.register();
            new Thread(new player(phaser),"player"+index).start();
        }
        System.out.println("Game Start");
        //ע����ǰ�߳�,������ʼ
//        phaser.arriveAndDeregister();
        //�Ƿ����ֹ̬һֱ�ȴ�
        while(!phaser.isTerminated()){
        }
        System.out.println("Game Over");
//        for(int i = 0; i < parties; i++) {
//            int threadId = i;
//            Thread thread = new Thread(() -> {
//                for(int phase = 0; phase < 5; phase++) {
//                    System.out.println(String.format("Thread %s, phase %s", threadId, phase));
//                    phaser.arriveAndAwaitAdvance();
//                }
//            });
//            thread.start();
//        }
    }

    static class player implements Runnable{

        private  final Phaser phaser ;

        player(Phaser phaser){
            this.phaser=phaser;
        }
        @Override
        public void run() {
            try {
                // ��һ�׶�??�ȴ������������߳��ٿ�ʼ
//                phaser.arriveAndAwaitAdvance();

                // �ڶ��׶�??�ȴ�����ѡ��׼�����ٿ�ʼ
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " ready");
                phaser.arriveAndAwaitAdvance();

                // �����׶�??�ȴ�����ѡ��׼���õ������󣬸��̴߳�phaser��ע�������ڽ�������Ľ׶Ρ�
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " arrived");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
