package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Classname OptionalBasics
 * @Description TODO
 * @Date 2021/6/19 0:10
 * @Created by gt136
 */
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent())
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    }

    public static void main(String[] args) {
        //流调用特定的方法就会转化成 Optional
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
/*
output:
Epithets
Nothing inside!
 */