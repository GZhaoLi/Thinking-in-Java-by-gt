package com.gui.demo.thingInJava.streamsProgram;

import java.util.stream.Stream;

/**
 * @Classname Fibonacci
 * @Description .
 * @Date 2021/6/10 23:56
 * @Created by gt136
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> number() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().number()
                .skip(20)//过滤前20个
                .limit(10) //然后取10个
                .forEach(System.out::println);
    }
}
/*
output:
6765
10946
17711
28657
46368
75025
121393
196418
317811
514229
 */