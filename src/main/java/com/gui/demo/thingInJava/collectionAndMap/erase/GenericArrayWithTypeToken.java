package com.gui.demo.thingInJava.collectionAndMap.erase;

import java.lang.reflect.Array;

/**
 * @Classname GenericArrayWithTypeToken
 * @Description TODO
 * @Date 2021/5/14 18:29
 * @Created by gt136
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type,sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gen = new GenericArrayWithTypeToken<>(Integer.class,10);
        Integer[] ia = gen.rep();
    }
}
