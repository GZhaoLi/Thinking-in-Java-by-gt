package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Classname OptionalsFromEmptyStreams
 * @Description optional
 * @Date 2021/6/17 23:54
 * @Created by gt136
 */
public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty()
                .findFirst());
        System.out.println(Stream.<String>empty()
                .findAny());
        System.out.println(Stream.<String>empty()
                .max(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty()
                .min(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty()
                .reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty()
                .average());
        Stream.of("1","2").reduce((n1,n2)->n2).ifPresent(System.out::println);
    }
}
/*
output:
Optional.empty
Optional.empty
Optional.empty
Optional.empty
Optional.empty
OptionalDouble.empty
 */