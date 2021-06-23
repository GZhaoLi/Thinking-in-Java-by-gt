package com.gui.demo.thingInJava.streamsProgram;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Classname StreamOf
 * @Description 流的创建和处理
 * @Date 2021/6/9 23:32
 * @Created by gt136
 */
public class StreamOf {
    public static void main(String[] args) {
        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3))
                .forEach(System.out::println);
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.1415926, 2.718, 1.618)
                .forEach(System.out::println);
        System.out.println("=====================================");

        List<Bubble> bubbles = Arrays.asList(new Bubble(3), new Bubble(4), new Bubble(5));
        System.out.println(bubbles.stream()
                //这个操作将流中的对象依次传入并返回对象中的一个整数重新构成流
                .mapToInt(b -> b.i)
                .sum());
        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream()
                //将流中元素依次传入并返回一个新的字符串流
                .map(x -> x + " ")
                //打印出的字符串无序是因为这是一个Set
                .forEach(System.out::print);
        System.out.println();
        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet()
        .stream()
        .map(e->e.getKey() + ":" + e.getValue())
        .forEach(System.out::println);
    }
}
/*
output:
Bubble{i=1}
Bubble{i=2}
Bubble{i=3}
It's a wonderful day for pie!
3.1415926
2.718
1.618
=====================================
12
a pie! It's for wonderful day
phi:1.618
e:2.718
pi:3.14159
 */