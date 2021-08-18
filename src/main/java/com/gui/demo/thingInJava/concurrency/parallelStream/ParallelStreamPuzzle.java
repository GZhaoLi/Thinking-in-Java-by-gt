package com.gui.demo.thingInJava.concurrency.parallelStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname ParallelStreamPuzzle
 * @Description 使用线程安全的ConcurrentLinkedDeque 和 AtomicInteger 使有序生成
 * @Date 2021/8/17 17:01
 * @Created by gt136
 */
public class ParallelStreamPuzzle {
    //新的线程安全队列
    public static final Deque<String> TRACE = new ConcurrentLinkedDeque<>();

    /**
     * int整数的生成器，实现了supplier。
     */
    static class IntGenerator implements Supplier<Integer> {
        //原子类，
        private AtomicInteger currentValue = new AtomicInteger();
        @Override
        public Integer get() {
            //这一步会有多个线程进来调用 add 方法，但是ConcurrentLinkedDeque 是线程安全的，所以会轮流执行
            TRACE.add(currentValue.get() + ": " + Thread.currentThread().getName());
            //会让等待的线程依次执行。
            return currentValue.getAndIncrement();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> x = Stream.generate(new IntGenerator())
                .limit(10)
                .parallel()
                .collect(Collectors.toList());
        System.out.println(x);
        Files.write(Paths.get("PSP.txt"), TRACE);
    }
}
/*
output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
