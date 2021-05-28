package com.gui.demo.thingInJava.collectionAndMap.erase;

import com.gui.demo.thingInJava.lunzi.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Classname FactoryConstraint
 * @Description TODO
 * @Date 2021/5/28 17:21
 * @Created by gt136
 */
class IntegerFactory implements Supplier<Integer>{
    private int i = 0;
    @Override
    public Integer get() {
        return ++i;
    }
}
class Widget{
    private int id;

    Widget(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Widget{" + id +
                '}';
    }

    public static class Factory implements Supplier<Widget> {
        private int i = 0;
        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}
class Fudge{
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge{"  + n +
                '}';
    }
}
class Foo<T>{
    private List<T> x = new ArrayList<>();

    Foo(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return "Foo{" +
                "x=" + x +
                '}';
    }
}
public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo<>(new IntegerFactory()));
        System.out.println(new Foo<>(new Widget.Factory()));
        System.out.println(new Foo<>(Fudge::new));
    }
}
/*
output:
Foo{x=[1, 2, 3, 4, 5]}
Foo{x=[Widget{1}, Widget{2}, Widget{3}, Widget{4}, Widget{5}]}
Foo{x=[Fudge{1}, Fudge{2}, Fudge{3}, Fudge{4}, Fudge{5}]}
 */