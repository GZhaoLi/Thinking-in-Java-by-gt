package com.gui.demo.thingInJava.lunzi;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Sets
 * @Description 产生集合的
 * @Date 2021/5/11 14:53
 * @Created by gt136
 */
public class Sets {
    //addAll()方法就是将另一个集合添加到这个集合中，Set中的addAll()方法如果两个集合都是Set，就是默认将两个set union起来。
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    //保存两个集合中共有的元素
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    //移除所共有的元素
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    //
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
