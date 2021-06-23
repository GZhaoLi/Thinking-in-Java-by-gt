package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname Apply
 * @Description 利用反射这个类中的apply方法能将任何方法引用于某个序列中的所有对象
 * @Date 2021/6/8 16:11
 * @Created by gt136
 */
public class Apply {
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                f.invoke(t, args);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            //如果报错就是程序员的错误
            throw new RuntimeException(e);
        }
    }
}
