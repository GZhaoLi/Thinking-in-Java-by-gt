package com.gui.demo.thingInJava.concurrency.parallelStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname ParallelStreamPuzzle32
 * @Description 创建整型的并行流
 * @Date 2021/8/18 10:47
 * @Created by gt136
 */
public class ParallelStreamPuzzle32 {
    public static void main(String[] args) {
        List<Integer> x = IntStream.range(0,30)
                .peek(e->System.out.println(e+": "+ Thread.currentThread().getName()))
                .limit(10)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(x);
    }
}
/*
output:
8: main
2: ForkJoinPool.commonPool-worker-6
1: ForkJoinPool.commonPool-worker-3
7: ForkJoinPool.commonPool-worker-6
6: ForkJoinPool.commonPool-worker-5
4: ForkJoinPool.commonPool-worker-1
3: ForkJoinPool.commonPool-worker-7
0: ForkJoinPool.commonPool-worker-4
5: main
9: ForkJoinPool.commonPool-worker-2
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 */