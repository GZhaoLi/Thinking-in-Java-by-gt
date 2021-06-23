package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Classname OptionalFlatMap
 * @Description flatmap
 * @Date 2021/6/21 11:24
 * @Created by gt136
 */
public class OptionalFlatMap {
    static String[] elements = {"12","", "23", "45"};

    static Stream<String> stream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.println("---(" + descr + ")----");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(stream()
                    .skip(i)
                    .findFirst()
                    .flatMap(func));//这里的参数变成了Optional类型
        }
    }

    public static void main(String[] args) {
        test("Add brackets", new Function<String, Optional<String>>() {
            @Override
            public Optional<String> apply(String s) {
                return Optional.of("[" + s + "]");
            }
        });
        test("Increment",s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (Exception e) {
                return Optional.of(s);
            }
        });
        test("Replace", s -> Optional.ofNullable(s.replace("2", "9")));
        test("Take last digit",s->Optional.of(s.length()>0?s.charAt(s.length()-1)+"":s));
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