package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname Futures
 * @Description TODO
 * @Date 2021/8/18 16:46
 * @Created by gt136
 */
public class Futures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec.submit(new CountingTask(99));
        //f.get() 会在上述任务执行完后并返回后执行
        System.out.println(f.get());
        exec.shutdown();
    }
}
/*
outputs:
99 pool-1-thread-1 100
100
 */