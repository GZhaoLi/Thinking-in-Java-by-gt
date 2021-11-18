package com.gui.demo.thingInJava.concurrency.share;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.*;
/**
 * 流使用了内部迭代的方式–也就是说，它们控制着自己的迭代器。
 * @Date 2021/8/14 17:47
 * @Created by gt136
 */
public class ParallelPrime {
    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        //rangeClosed返回一个递增1的有序序列且包含最后一个节点，range的话不包含。如果第二个参数小于初始值，则返回空流
        // sqrt()返回n的正平方根，如n=4，sqrt(n)=+2;如果n=6,sqrt(n)=+2.445，但是将其转化为long型后就会将2.445直接舍去小数位
        //所以4以前返回空流但是结果为true，5-8都为2
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);//所有数据不满足条件才返回true，空也返回true
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        List<String> primes =
                iterate(2,i->i+1)
                .parallel()     //[1]
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println(timer.duration());
        //System.out.println((long) Math.sqrt(8));
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}
/*
output:
1110
 */
