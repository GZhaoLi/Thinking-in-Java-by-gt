package com.gui.demo.thingInJava.streamsProgram;

import java.util.Random;

import static java.util.stream.IntStream.*;
/**
 * @Classname Ranges
 * @Description range的使用
 * @Date 2021/6/10 16:25
 * @Created by gt136
 */
public class Ranges {
    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i->action.run());
    }
    public static void main(String[] args) {
        //传统方法
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);
        //for-in 循环
        result = 0;
        for (int i : range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);
        //使用流
        System.out.println(range(10,20).sum());
        //使用流但是不适用IntStream中的方法
        System.out.println(new Random()
                .ints(10, 20)
                .limit(5).sum());

        repeat(3,()-> System.out.println("Looping!"));
    }

}
