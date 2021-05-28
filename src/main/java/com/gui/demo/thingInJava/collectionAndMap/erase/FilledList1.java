package com.gui.demo.thingInJava.collectionAndMap.erase;

import com.gui.demo.thingInJava.lunzi.Suppliers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Classname FilledList1
 * @Description 擦除的边界
 * @Date 2021/5/28 11:17
 * @Created by gt136
 */
public class FilledList1<T> extends ArrayList<T> {
    FilledList1(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    public FilledList1(T t, int size) {
        for (int i = 0; i < size; i++) {
            this.add(t);
        }
    }

    public static void main(String[] args) {
        List<String> list = new FilledList1<>("Hello", 4);
        System.out.println(list);
        //Supplier 版本
        List<Integer> integerList = new FilledList1<>(() -> 47, 4);
        System.out.println(integerList);
    }

    T[] create(Class<T> c, int size) {
        return (T[]) Array.newInstance(c, size);
    }
}
/*
output:
[Hello, Hello, Hello, Hello]
[47, 47, 47, 47]
 */