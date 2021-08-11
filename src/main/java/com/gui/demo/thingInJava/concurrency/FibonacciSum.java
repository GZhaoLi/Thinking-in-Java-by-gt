package com.gui.demo.thingInJava.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname FibonacciSum2
 * @Description 计算总和的斐波那契数字数量
 * @Date 2021/7/20 17:20
 * @Created by gt136
 */
class Fibonacci{
    private static ExecutorService es;

    private static int fib(int n) {
        if (n == 0 || n==1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static synchronized Future<Integer> runTask(final int n) {
        assert es != null;
        return es.submit(() -> {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += fib(i);
            }
            return sum;
        });
    }

    public static synchronized void init() {
        if (es == null) es = Executors.newCachedThreadPool();
    }

    public static synchronized void shutdown() {
            if (es != null) es.shutdown();
        es = null;
    }
}

public class FibonacciSum {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<>();
        Fibonacci.init();
        for (int i = 0; i <= 5; i++) {
            results.add(Fibonacci.runTask(i));
        }
        Thread.yield();
        Fibonacci.shutdown();
        for (Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
output:
0
1
2
4
7
12
 */