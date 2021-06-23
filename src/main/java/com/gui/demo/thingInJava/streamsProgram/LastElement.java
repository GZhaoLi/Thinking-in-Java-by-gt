package com.gui.demo.thingInJava.streamsProgram;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Classname LastElement
 * @Description TODO
 * @Date 2021/6/23 9:57
 * @Created by gt136
 */
public class LastElement {
    public static void main(String[] args) {
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));

        Optional<String> lastobj = Stream.of("one", "two", "three")
                .reduce((n1, n2) -> n2);
        System.out.println(lastobj.orElse("Nothing there"));
    }
}
/*
output:
19
three
 */