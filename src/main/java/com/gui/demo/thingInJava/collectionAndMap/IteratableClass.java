package com.gui.demo.thingInJava.collectionAndMap;

import java.util.Iterator;

/**
 * @Classname IteratableClass
 * @Description TODO
 * @Date 2021/4/1 15:06
 * @Created by gt136
 */
public class IteratableClass implements Iterable<String> {
    public String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IteratableClass()) {
            System.out.print(s + " ");
        }
    }
}
