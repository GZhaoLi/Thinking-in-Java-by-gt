package com.gui.demo.thingInJava.streamsProgram;

import java.util.Arrays;

/**
 * @Classname ArrayStreams
 * @Description TODO
 * @Date 2021/6/15 15:00
 * @Created by gt136
 */
public class ArrayStreams {
    public static void main(String[] args) {
        Arrays.stream(new double[]{3.14159, 2.718, 1.618 })
                .forEach(n->System.out.format("%f ", n));
        System.out.println();
        Arrays.stream(new int[]{1, 3, 5})
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        Arrays.stream(new long[]{11, 22, 33, 44, 66})
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        //选择一个子域
        Arrays.stream(new int[]{1, 3, 5, 7, 8, 10, 12}, 3, 6)
                .forEach(n -> System.out.format("%d ", n));
    }
}
/*
output:
3.141590 2.718000 1.618000
1 3 5
11 22 33 44 66
7 8 10
 */
