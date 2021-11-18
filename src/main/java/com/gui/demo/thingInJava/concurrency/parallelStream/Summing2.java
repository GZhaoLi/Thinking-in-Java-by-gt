package com.gui.demo.thingInJava.concurrency.parallelStream;

import java.util.Arrays;

/**
 * 在数组中填值并对数组求和
 * @Date 2021/8/16 14:36
 * @Created by gt136
 */
public class Summing2 {
    /**
     * 对数组求和
     * @param ia
     * @return
     */
    static long basicSum(long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 20_000_000;
    //求和
    public static final long CHECK = (long)SZ * ((long) SZ + 1)/2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        long[] la = new long[SZ + 1];
        //根据第二个参数generator来对生成一个数组长度大小的有序队列，并将值其数组值替换，如果generator为null，抛出异常
        Arrays.parallelSetAll(la, i -> i);

        Summing.timeTest("Array Stream Sum", CHECK, () -> Arrays.stream(la).sum());
        Summing.timeTest("Parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
        Summing.timeTest("Basic Sum", CHECK, () -> basicSum(la));
        Summing.timeTest("ParallelPrefix",CHECK,()->{
            //这个方法会将数组的前几位的值求和并加上第i位的值赋值给la[i]；la[la.length - 1]的值就是求和
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });
    }
}
/*
output
200000010000000
Array Stream Sum: 25ms
Parallel: 19ms
Basic Sum: 16ms
ParallelPrefix: 98ms
 */