package com.gui.demo.thingInJava.concurrency.parallelStream;

import com.gui.demo.thingInJava.concurrency.share.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 *
 * @Date 2021/8/16 10:34
 * @Created by gt136
 */
public class Summing {
    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + "ms");
        }else {
            System.out.format("result: %d%ncheckVallue:%d%n",result,checkValue);
        }
    }

    public static final int SZ = 100_000_000;
    //SZ以内数字的求和
    public static final long CHECK = (long) SZ * ((long)SZ + 1) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("Sum Stream",CHECK, () -> LongStream.rangeClosed(0, SZ).sum());//正常求和
        timeTest("Sum Stream Parallel",CHECK,()->LongStream.rangeClosed(0,SZ).parallel().sum());//并行化求和
        timeTest("Sum Iterate: ",CHECK,()->LongStream.iterate(0,i->i+1).limit(SZ+1).sum());//内部迭代求和
        timeTest("Sum Iterated Parallel",CHECK,()->LongStream.iterate(0,i->i+1).parallel().limit(SZ+1).sum());//内部迭代并行求和
    }

}
/*
output =
5000000050000000
Sum Stream: 52ms
Sum Stream Parallel: 21ms
Sum Iterate: : 97ms
Sum Iterated Parallel: 2759ms
 */