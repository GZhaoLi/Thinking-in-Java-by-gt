package com.gui.demo.thingInJava.streamsProgram;

import java.util.*;

/**
 * @Classname ImperativeRandoms
 * @Description TODO
 * @Date 2021/6/9 16:19
 * @Created by gt136
 */
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rd = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rd.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
/*
output:
[7, 8, 9, 11, 15, 16, 18]
 */