package com.gui.demo.thingInJava.collectionAndMap;

import java.util.Iterator;

/**
 * @Classname IterableFibonacci
 * @Description
 * @Date 2021/5/10 15:56
 * @Created by gt136
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i: new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}
