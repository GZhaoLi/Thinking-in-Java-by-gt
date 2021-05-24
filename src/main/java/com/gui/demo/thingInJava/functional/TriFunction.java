package com.gui.demo.thingInJava.functional;

/**
 * @Classname TriFunction
 * @Description 多参数函数式接口
 * @Date 2021/5/24 11:31
 * @Created by gt136
 */
@FunctionalInterface
public interface TriFunction<T, U, R, V> {
    R apply(T t, U u, V v);
}
