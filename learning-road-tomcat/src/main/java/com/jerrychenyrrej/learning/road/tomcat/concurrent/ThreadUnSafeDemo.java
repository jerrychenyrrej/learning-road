package com.jerrychenyrrej.learning.road.tomcat.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: un safe thread demo
 * @author: jerrychenyrrej
 * @create: 2024-01-08 23:17
 **/
public class ThreadUnSafeDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadUnSafeDemo.class);
    public static final int THREAD_SIZE = 1000;
    public static final CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);
    public static final ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < THREAD_SIZE; i++) {
            executorService.execute(() -> {
                counter.increment();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        LOGGER.info("main", counter.getCount());
    }
}

class Counter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Counter.class);
    private int count = 0;

    public void increment() {
        LOGGER.info("increment", Thread.currentThread().getName() + count);
        count++;
    }

    public int getCount() {
        return this.count;
    }
}