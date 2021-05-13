package com.gui.demo.thingInJava.collectionAndMap;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Classname HashSetDemo
 * @Description TODO
 * @Date 2021/4/1 13:49
 * @Created by gt136
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            intSet.add(random.nextInt(30));
        }
        System.out.println(intSet);
    }
}
