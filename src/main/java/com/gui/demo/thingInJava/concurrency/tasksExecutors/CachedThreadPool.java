package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Classname CachedThreadPool
 * @Description TODO
 * @Date 2021/8/18 15:42
 * @Created by gt136
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
/*
output:
1 pool-1-thread-2 100
2 pool-1-thread-3 300
3 pool-1-thread-4 200
0 pool-1-thread-1 100
6 pool-1-thread-7 400
4 pool-1-thread-5 500
7 pool-1-thread-8 600
9 pool-1-thread-10 700
5 pool-1-thread-6 800
8 pool-1-thread-9 900
 */