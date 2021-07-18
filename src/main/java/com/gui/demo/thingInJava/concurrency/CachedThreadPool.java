package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CachedThreadPool
 * @Description 线程池：CachedThreadPool将为每个任务创建一个线程
 *               注意：ExecutorService 对象是使用静态的 Executors 方法创建的：它继承了Executor类，但它是个接口。
 *               这个方法返回新创建的线程池
 *               return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
 *                                       60L, TimeUnit.SECONDS,
 *                                       new SynchronousQueue<Runnable>());
 * @Date 2021/7/16 18:02
 * @Created by gt136
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            //第一步先在主线程循环中完成了
            es.execute(new LiftOff());
        }
        es.shutdown();
    }
}
