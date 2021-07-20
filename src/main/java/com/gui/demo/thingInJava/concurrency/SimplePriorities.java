package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname SimplePriorities
 * @Description 显示不同优先级的线程
 * @Date 2021/7/19 11:08
 * @Created by gt136
 */
public class SimplePriorities implements Runnable{
    private int countDown = 3;
    private volatile double d; //没有最佳化,编译器不进行优化
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread()+": " + countDown ;
    }

    @Override
    public void run() {
        //设置优先级,而不是在构造器中
        Thread.currentThread().setPriority(priority);
        while (true) {
            //下面是一个昂贵的、无法干预的操作
            for (int i = 1; i < 1000000000; i++) {
                d += (Math.PI + Math.E) / i;
                if (i % 1000 == 0) Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            service.execute(
                    new SimplePriorities(Thread.MIN_PRIORITY)
            );
        }
        service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        service.shutdown();
    }
}
/*
output:pool-1-thread-4:这是构造器自动生成的名字，第二个字段是优先级；
Thread[pool-1-thread-4,10,main]: 3
Thread[pool-1-thread-3,1,main]: 3
Thread[pool-1-thread-1,1,main]: 3
Thread[pool-1-thread-2,1,main]: 3
Thread[pool-1-thread-4,10,main]: 2
Thread[pool-1-thread-3,1,main]: 2
Thread[pool-1-thread-1,1,main]: 2
Thread[pool-1-thread-2,1,main]: 2
Thread[pool-1-thread-4,10,main]: 1
Thread[pool-1-thread-1,1,main]: 1
Thread[pool-1-thread-2,1,main]: 1
Thread[pool-1-thread-3,1,main]: 1
 */