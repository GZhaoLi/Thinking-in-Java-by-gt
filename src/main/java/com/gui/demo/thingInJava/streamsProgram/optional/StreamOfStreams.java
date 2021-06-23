package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Classname StreamOfStreams
 * @Description TODO
 * @Date 2021/6/17 16:41
 * @Created by gt136
 */
public class StreamOfStreams {
    static Random rand = new Random(47);
    public static void main(String[] args) {
        Stream.of(1,2,3)
                .map(i->Stream.of("Gonzo","Kermit","Breaker"))
                .map(e->e.getClass().getName())
                .forEach(System.out::println);

        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Breaker"))
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100).limit(i), IntStream.of(-1)))
                .forEach(n -> System.out.format("%d ", n));

    }
}
/*
output:
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
Gonzo
Kermit
Breaker
Gonzo
Kermit
Breaker
Gonzo
Kermit
Breaker
58 -1 55 93 -1 61 61 29 -1 68 0 22 7 -1 88 28 51 89 9 -1
 */