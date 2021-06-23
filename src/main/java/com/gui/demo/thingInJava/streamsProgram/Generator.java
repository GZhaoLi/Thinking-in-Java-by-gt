package com.gui.demo.thingInJava.streamsProgram;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname Generator
 * @Description generate的用法
 * @Date 2021/6/10 22:16
 * @Created by gt136
 */
public class Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return "" + letters[rand.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        String word = Stream.generate(new Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);

        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
/*
output:
YNZBRNYGCFOWZNTCQRGSEGZMMJMROE
 */