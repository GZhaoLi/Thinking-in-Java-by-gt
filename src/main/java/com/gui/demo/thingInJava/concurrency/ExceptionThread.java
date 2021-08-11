package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ExceptionThread
 * @Description 線程捕獲異常
 * @Date 2021/7/22 14:14
 * @Created by gt136
 */
public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ExceptionThread());
    }
}
/*
output:
Exception in thread "pool-1-thread-1" java.lang.RuntimeException
	at com.gui.demo.thingInJava.concurrency.ExceptionThread.run(ExceptionThread.java:16)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run
 */