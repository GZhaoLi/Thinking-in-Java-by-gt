package com.gui.demo.thingInJava.streamsProgram;

import java.util.Random;

/**
 * @Classname Randoms
 * @Description 示例 1
 * @Date 2021/6/9 15:13
 * @Created by gt136
 */
public class Randoms {
    public static void main(String[] args) {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }
}
/*
output：
6
10
13
16
17
18
19
 */