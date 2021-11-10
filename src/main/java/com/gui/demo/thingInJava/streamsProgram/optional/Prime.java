package com.gui.demo.thingInJava.streamsProgram.optional;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.*;

/**
 * @Classname Prime
 * @Description
 * @Date 2021/6/17 9:27
 * @Created by gt136
 */
public class Prime {
    //过滤质数
    public static Boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))//产生一个从第一个参数到第二个参数依次递增一的序列，包含了初始值与上限值
                .noneMatch(i -> n % i == 0);//
    }

    public static LongStream numbers() {
        return iterate(2, i -> i + 1)//产生一个从 2 开始的无限序列
                .filter(Prime::isPrime);//过滤非质数
    }

    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n-> System.out.format("%d ",n));
    }
}
/*
output:
2 3 5 7 11 13 17 19 23 29
467 479 487 491 499 503 509 521 523 541
*/