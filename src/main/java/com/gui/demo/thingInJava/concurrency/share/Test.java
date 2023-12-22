package com.gui.demo.thingInJava.concurrency.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {



    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        AtomicInteger i = new AtomicInteger();

        Map<Integer, String> maps = strings.stream()
                .collect(Collectors.toMap(
                                b-> i.getAndIncrement(),
                                Function.identity()
                        ));
        System.out.println(maps);


    }


}
