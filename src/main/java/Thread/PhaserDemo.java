package Thread;

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

        // 十名选手
        for (int index = 0; index < 10; index++) {
            phaser.register();
            new Thread(new player(phaser),"player"+index).start();
        }
        System.out.println("Game Start");
        //注销当前线程,比赛开始
//        phaser.arriveAndDeregister();
        //是否非终止态一直等待
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
                // 第一阶段??等待创建好所有线程再开始
//                phaser.arriveAndAwaitAdvance();

                // 第二阶段??等待所有选手准备好再开始
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " ready");
                phaser.arriveAndAwaitAdvance();

                // 第三阶段??等待所有选手准备好到达，到达后，该线程从phaser中注销，不在进行下面的阶段。
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " arrived");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
