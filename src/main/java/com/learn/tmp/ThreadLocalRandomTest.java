package com.learn.tmp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadLocalRandomTest {

    public final static int N = 100000;
    @Test
    public void testRandom() throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();

        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < ThreadLocalRandomTest.N; i++) {
            callables.add(()->{
                return ThreadLocalRandom.current().nextInt();
            });
        }
        executorService.invokeAll(callables);
        System.out.println(System.currentTimeMillis() - start);
    }
}
