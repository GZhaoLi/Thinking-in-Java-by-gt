package com.gui.demo.thingInJava.collectionAndMap;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Classname Government
 * @Description TODO
 * @Date 2021/5/7 17:28
 * @Created by gt136
 */
public class Government implements Generator {
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is a no basis for a system of government").split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}
class CollectionDataTest{
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 16));
        //
        set.addAll(CollectionData.list(new Government(), 16));
        System.out.println(set);
    }
}
/*
输出：
[strange, women, lying, in, ponds, distributing, swords, is, a, no, basis, for, system, of, government]
 */