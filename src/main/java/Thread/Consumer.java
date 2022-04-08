//package Thread;
//
//public class Consumer implements Runnable{
//    public static int LipinCount = 1000;
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (Consumer.class) {
//                while (LipinCount == 0) {
//                    try {
//                        LOCK.wait();
//                    } catch (Exception e) {
//                    }
//                }
//                count--;
//                System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
//                LOCK.notifyAll();
//            }
//        }
//    }
//
//
//}
