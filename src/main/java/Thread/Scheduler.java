//package Thread;
//
//import java.util.concurrent.LinkedTransferQueue;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Scheduler {
//
//    // ���ж��� SynchronousQueue��LinkedTransferQueue;
//    LinkedTransferQueue<Runnable> tasks = new LinkedTransferQueue<>();
//    static AtomicInteger idCount = new AtomicInteger(0);
//
//    public Scheduler(int workerCount){
//        for (int i = 0; i < workerCount; i++) {
//            new Thread(new worker()).start();
//        }
//    }
//    public void submit(Runnable runnable){
//        while(!tasks.tryTransfer(runnable)){
//            Thread.onSpinWait();
//            new Thread(new worker()).start();
//        }
//    }
//
//    class worker implements Runnable{
//        int id;
//        public worker(){
//            this.id = idCount.getAndIncrement();
//        }
//
//        @Override
//        public void run() {
//            while (true){
//                Runnable runnable = null;
//                try {
//                    runnable = tasks.take();
//                    System.out.format("work done by id=%d\n", id);
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        Scheduler scheduler = new Scheduler(10);
//        for (int i = 0; i < 1000; i++) {
//            int local = i;
//            scheduler.submit(()->{
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//    }
//
//
//}
