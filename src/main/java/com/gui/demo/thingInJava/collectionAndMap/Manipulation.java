package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname Manipulatol
 * @Description TODO
 * @Date 2021/5/13 14:16
 * @Created by gt136
 */
class HasF{
    public void f(){
        System.out.println("HasF.f()");
    }
}
class Manipulator<T extends HasF>{
    private T obj;

    public Manipulator(T t) {
        obj = t;
    }

    public void manipulate() {
        obj.f();
    }
}
public class Manipulation {
    public static void main(String[] args) {
        Manipulator<HasF> manipulator = new Manipulator<>(new HasF());
        manipulator.manipulate();
    }
}
