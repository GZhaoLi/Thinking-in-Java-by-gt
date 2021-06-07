package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.List;

/**
 * @Classname SuperTypeWildcards
 * @Description TODO
 * @Date 2021/6/2 16:57
 * @Created by gt136
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}

class Orange extends Fruit {

}
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Orange());
    }
}
