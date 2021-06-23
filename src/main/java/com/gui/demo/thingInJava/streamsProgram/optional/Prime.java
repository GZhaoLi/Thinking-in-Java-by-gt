package com.gui.demo.thingInJava.streamsProgram.optional;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.*;

/**
 * @Classname Prime
 * @Description TODO
 * @Date 2021/6/17 9:27
 * @Created by gt136
 */
public class Prime {
    //过滤质数
    public static Boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public static LongStream numbers() {
        return iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
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