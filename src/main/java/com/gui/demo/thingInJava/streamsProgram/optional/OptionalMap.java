package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Classname OptionalMap
 * @Description optional中的map操作
 * @Date 2021/6/21 10:51
 * @Created by gt136
 */
public class OptionalMap {
    static String[] elements = {"12", "", "23", "45"};
    static Stream<String> stream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String,String> func) {
        System.out.println("---(" + descr + ")----");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(stream()
                    .skip(i)
                    .findFirst()//此处产生一个optional
                    .map(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> "[" + s + "]");
        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (Exception e) {
                return s;
            }
        });
        test("Replace", s -> s.replace("2", "9"));
        //记得每个s是单个流元素
        test("Take last digit", s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);
    }
}
/*
output:
---(Add brackets)----
Optional[[12]]
Optional[[]]
Optional[[23]]
Optional[[45]]
Optional.empty
---(Increment)----
Optional[13]
Optional[]
Optional[24]
Optional[46]
Optional.empty
---(Replace)----
Optional[19]
Optional[]
Optional[93]
Optional[45]
Optional.empty
---(Take last digit)----
Optional[2]
Optional[]
Optional[3]
Optional[5]
Optional.empty
 */