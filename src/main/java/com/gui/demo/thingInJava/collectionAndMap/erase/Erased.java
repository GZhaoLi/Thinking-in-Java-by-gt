package com.gui.demo.thingInJava.collectionAndMap.erase;

/**
 * @Classname Erased
 * @Description TODO
 * @Date 2021/5/28 16:29
 * @Created by gt136
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
        /*//编译错误
        if (arg instanceof T) {}
        //编译错误
        T var = new T();
        //编译错误
        T[] array = new T[SIZE];
        //Unchecked cast: 'java.lang.Object[]' to 'T[]'
        T[] array2 = (T[]) new Object[SIZE];*/
    }
}
