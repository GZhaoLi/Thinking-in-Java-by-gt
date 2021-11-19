package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import java.util.stream.IntStream;

/**
 * 同时运行多个互不干扰的任务
 * @Date 2021/8/18 17:14
 * @Created by gt136
 */
public class CountingStream {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0,10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(countingTask -> {
                    try {
                        return countingTask.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(0,Integer::sum)
        );
    }
}
/*
output:
1 pool-1-thread-2 100
0 pool-1-thread-1 100
3 pool-1-thread-4 100
2 pool-1-thread-3 100
5 pool-1-thread-6 100
4 pool-1-thread-5 100
6 pool-1-thread-7 100
7 pool-1-thread-8 100
8 pool-1-thread-9 100
9 pool-1-thread-10 100
sum = 1000
 */