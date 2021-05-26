package com.gui.demo.thingInJava.lunzi;

import java.util.function.Supplier;

/**
 * @Classname BasicSupplier
 * @Description TODO
 * @Date 2021/5/26 16:24
 * @Created by gt136
 */
public class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
