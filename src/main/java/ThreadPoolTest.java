import org.junit.Test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.execute(()->{
                Random random = new Random(System.currentTimeMillis());
                long time = random.nextInt(1000) ;
                long start = System.currentTimeMillis();
                while (true){
                    if(System.currentTimeMillis() - start >= time){
                        break;
                    }
                }
            });
        }

        while (true) {
            System.out.println();

            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("队列中的任务：" + queueSize);

            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            Thread.sleep(3000);
        }
    }

    @Test
    public void testRandom(){
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("我要推出了");
        }));

        while (true){

        }
    }


}
