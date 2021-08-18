package com.gui.demo.thingInJava.concurrency.share;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author gt136
 * @Classname CircularSet
 * @Description TODO
 * @Date 2021/8/12 17:32
 * @Created by gt136
 */
public class CircularSet {
    private int[] array;
    private int size;
    private int index = 0;

    public CircularSet(int size) {
        this.size = size;
        array = new int[size];
        //初始化不产生值
        Arrays.fill(array, -1);
    }

    public synchronized void add(int i) {
        array[index] = i;
        //覆盖之前的值:index相当于后移一位
        index = ++ index % size;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < size; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
