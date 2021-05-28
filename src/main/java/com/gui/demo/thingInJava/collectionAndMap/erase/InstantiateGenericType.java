package com.gui.demo.thingInJava.collectionAndMap.erase;

import java.util.function.Supplier;

/**
 * @Classname ClassAsFactory
 * @Description TODO
 * @Date 2021/5/28 16:57
 * @Created by gt136
 */
class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            return kind.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException(exception);
        }
    }
}
class Employee{
    @Override
    public String toString() {
        return "Employee{}";
    }
}
public class InstantiateGenericType{
    public static void main(String[] args) {
        ClassAsFactory<Employee> caf = new ClassAsFactory<>(Employee.class);
        System.out.println(caf.get());
        ClassAsFactory<Integer> af = new ClassAsFactory<>(Integer.class);
        try {
            System.out.println(af.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
output:
Employee{}
java.lang.InstantiationException: java.lang.Integer
 */