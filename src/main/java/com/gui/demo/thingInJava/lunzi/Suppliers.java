package com.gui.demo.thingInJava.lunzi;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Classname Suppliers
 * @Description 使用生成器填充Collection的工具方法
 * @Date 2021/5/28 11:30
 * @Created by gt136
 */
public class Suppliers {
    //创建一个集合并填充它
    public <T, C extends Collection<T>> C create(Supplier<C> factory, Supplier<T> gen, int n) {
        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }

    //填充一个现有的集合
    public static <T, C extends Collection<T>> C fill(C coll, Supplier<T> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);
        return coll;
    }

    //使用一个未绑定的方法引用去产生一个更通用的方法
    public static <H, A> H fill(H holder, BiConsumer<H, A> adder, Supplier<A> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(a -> adder.accept(holder, a));
        return holder;
    }
}
