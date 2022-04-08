package rxJava;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testRxJavaWithoutBlocking {
    public static void main(String[] args) throws InterruptedException {
        int count = 10000;
        ExecutorService es = Executors.newFixedThreadPool(200, new ThreadFactoryBuilder().setNameFormat("SubscribeOn-%d").build());

        CountDownLatch finishedLatch = new CountDownLatch(1);
        long t = System.nanoTime();
        Observable.range(0, count).subscribeOn(Schedulers.io()).flatMap(i -> {
            return Observable.just(i).subscribeOn(Schedulers.from(es)).map(v -> {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 200;
            });
        }).observeOn(Schedulers.computation()).subscribe(statusCode -> {
            //System.out.println("B:" + Thread.currentThread().getName());
        }, error -> {
        }, () -> {
            finishedLatch.countDown();
        });
        finishedLatch.await();
        t = (System.nanoTime() - t) / 1000000; //ms
        System.out.println("RxJavaWithoutBlocking TPS: " + count * 1000 / t);
    }
}
