package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;


/**
 * @Classname Shape
 * @Description 测试Apply类中的apply方法
 * @Date 2021/6/8 16:18
 * @Created by gt136
 */
public class Shape {
    private static long counter = 0;
    //如果这一句加上static ，那么即使是final引用，值也不会改变!!
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
    //旋转，循环
    public void rotate() {
        System.out.println(this + " rotate ");
    }

    //调整
    public void resize(int newSize) {
        System.out.println(this + " resize " + newSize);
    }
}
