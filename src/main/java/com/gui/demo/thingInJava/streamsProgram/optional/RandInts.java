package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Classname RandInts
 * @Description 将流转化为数组
 * @Date 2021/6/21 14:53
 * @Created by gt136
 */
public class RandInts {
    private static int[] rints = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();//将流转化为数组

    public static IntStream rands() {
        return Arrays.stream(rints);//将数组转化为流
    }
}
