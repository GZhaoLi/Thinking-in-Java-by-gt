package com.gui.demo.utils;

import com.gui.demo.thingInJava.collectionAndMap.Generator;

/**
 * @Classname BasicGenerator
 * @Description 为一个具有默认构造器的类自动地创造一个Generator
 * @Date 2021/5/11 13:59
 * @Created by gt136
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            //type的类型必须是public的
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
