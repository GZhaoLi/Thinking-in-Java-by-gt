package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Classname FunctionMap
 * @Description TODO
 * @Date 2021/6/17 15:02
 * @Created by gt136
 */
public class FunctionMap {
    static String[] elements = {"12", "", "23", "34"};
    //将数组转换为流
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.println("---( " + descr + ")---");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //使原数据变为我们想要的形式
        test("add brackets", s -> "[" + s + "]");
        test("Increment",s->{
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

    }
}
/*
output:
---( add brackets)---
[12]
[]
[23]
[34]
---( Increment)---
13

24
35
 */