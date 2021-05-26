package com.gui.demo.thingInJava.functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Classname PredicateComposition
 * @Description Predicate:谓词，v断言，断定     Composition:组成，构成
 * @Date 2021/5/25 22:04
 * @Created by gt136
 */
public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 6,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar","foobar","foobaz","fungopuckey")
                .filter(p4)
                .forEach(System.out::println);
    }
}
/*
foobar
foobaz
 */