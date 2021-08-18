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
0 pool-1-thread-1 200
1 pool-1-thread-2 200
2 pool-1-thread-3 300
3 pool-1-thread-4 400
6 pool-1-thread-7 500
7 pool-1-thread-8 600
9 pool-1-thread-2 700
4 pool-1-thread-5 800
5 pool-1-thread-6 900
8 pool-1-thread-9 1000
 */