package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.utils.New;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenericVarargs
 * @Description 可变参数
 * @Date 2021/5/11 11:06
 * @Created by gt136
 */
public class GenericVarargs {
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> results = New.list();
        for (T item : args) {
            results.add(item);
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
    }
}
/*
输出：
[A]
[A, B, C]
 */