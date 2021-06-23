package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Classname OptionalFilter
 * @Description optional 对象操作
 * @Date 2021/6/21 9:55
 * @Created by gt136
 */
public class OptionalFilter {
    static String[] elements = {"Foo", "Bar", "Baz", "Bingo"};
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Predicate<String> predicate) {
        System.out.println("---(" + descr + ")----");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream()
                    .skip(i)
                    .findFirst()
                    .filter(predicate));
        }
    }

    public static void main(String[] args) {
        test("true", s -> true);
        test("false", s -> false);
        test("s != \"\"", s -> s != "");
        //此处的s.length() 是传入的单个流元素
        test("s.length() == 3", s -> s.length() == 3);
        test("startsWith(\"B\")", s -> s.startsWith("B"));
    }
}
/*
output:
---(true)----
Optional[Foo]
Optional[Bar]
Optional[Baz]
Optional[Bingo]
Optional.empty
---(false)----
Optional.empty
Optional.empty
Optional.empty
Optional.empty
Optional.empty
---(s != "")----
Optional[Foo]
Optional[Bar]
Optional[Baz]
Optional[Bingo]
Optional.empty
---(s.length() == 3)----
Optional[Foo]
Optional[Bar]
Optional[Baz]
Optional.empty
Optional.empty
---(startsWith("B"))----
Optional.empty
Optional[Bar]
Optional[Baz]
Optional[Bingo]
Optional.empty
 */