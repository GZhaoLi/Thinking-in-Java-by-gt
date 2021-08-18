package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname CachedThreadPool3
 * @Description TODO
 * @Date 2021/8/18 16:27
 * @Created by gt136
 */
public class CachedThreadPool3 {
    public static Integer extractResult(Future<Integer> future) {
        try {
            //返回计算的结果
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<CountingTask> tasks =
                IntStream.range(0, 10)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());
        List<Future<Integer>> futures = exec.invokeAll(tasks);
        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}
/*
output:
0 pool-1-thread-1 100
3 pool-1-thread-4 100
1 pool-1-thread-2 100
6 pool-1-thread-7 100
2 pool-1-thread-3 100
7 pool-1-thread-8 100
5 pool-1-thread-6 100
4 pool-1-thread-5 100
8 pool-1-thread-9 100
9 pool-1-thread-10 100
sum = 1000
 */
