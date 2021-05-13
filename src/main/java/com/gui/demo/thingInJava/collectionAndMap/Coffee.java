package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname Coffee
 * @Description TODO
 * @Date 2021/5/10 9:59
 * @Created by gt136
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
