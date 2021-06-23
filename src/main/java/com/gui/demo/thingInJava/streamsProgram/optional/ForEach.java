package com.gui.demo.thingInJava.streamsProgram.optional;

import static com.gui.demo.thingInJava.streamsProgram.optional.RandInts.rands;

/**
 * @Classname ForEach
 * @Description TODO
 * @Date 2021/6/21 15:42
 * @Created by gt136
 */
public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        rands().limit(SZ)
                .forEach(value -> System.out.format("%d ", value));
        System.out.println(
        );
        rands().limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        rands().limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}
/*
output:
258 555 693 861 961 429 868 200 522 207 288 128 551 589
551 589 861 288 555 868 693 207 128 200 961 429 258 522
258 555 693 861 961 429 868 200 522 207 288 128 551 589
 */