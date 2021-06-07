package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import com.gui.demo.thingInJava.RTTI.Cat;
import com.gui.demo.thingInJava.RTTI.Dog;
import com.gui.demo.thingInJava.RTTI.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname CheckedList
 * @Description TODO
 * @Date 2021/6/4 14:37
 * @Created by gt136
 */
public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        //这里这个集合接受了一个Cat型
        oldStyleMethod(dogs);
        //这里使用了Collections中的便利工具：checkedList();它的第一个参数为你需要动态检查的集合，第二个参数为你希望强制要求的类型
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }

        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());

    }
}
/*
output:
Expected: java.lang.ClassCastException: Attempt to insert class Cat element into
collection with element type class Dog
 */