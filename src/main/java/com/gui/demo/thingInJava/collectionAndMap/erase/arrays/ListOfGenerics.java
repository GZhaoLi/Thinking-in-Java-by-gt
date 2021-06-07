package com.gui.demo.thingInJava.collectionAndMap.erase.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ListOfGenerics
 * @Description TODO
 * @Date 2021/5/29 12:18
 * @Created by gt136
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
