package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CachedThreadPool
 * @Description 线程池：CachedThreadPool将为每个任务创建一个线程
 *               注意：ExecutorService（它继承了Executor类，但它是个接口。） 对象是使用Executors的静态方法创建的：
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
/*
output:
----
----
----
#0(9),
#0(8),
#0(7),
#0(6),
#0(5),
#0(4),
#1(9),
#2(9),
#0(3),
#0(2),
#2(8),
#0(1),
#0(LiftOff!),
#1(8),
#2(7),
#1(7),
#2(6),
#2(5),
#1(6),
#2(4),
#1(5),
#2(3),
#1(4),
#2(2),
#1(3),
#2(1),
#1(2),
#2(LiftOff!),
#1(1),
#1(LiftOff!),
 */