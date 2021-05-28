package com.gui.demo.thingInJava.collectionAndMap.erase;

/**
 * @Classname CreatorGeneric
 * @Description TODO
 * @Date 2021/5/28 17:47
 * @Created by gt136
 */
abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate() {
        element = create();
    }
    abstract T create();
}
class X{}

class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }
    void f() {
        System.out.println(
                element.getClass().getSimpleName());
    }
}
public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}
/*
output:
X
 */