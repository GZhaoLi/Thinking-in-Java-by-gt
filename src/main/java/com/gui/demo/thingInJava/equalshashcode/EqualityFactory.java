package com.gui.demo.thingInJava.equalshashcode;

/**
 * @Classname EqualityFactory
 * @Description 工厂函数设计模式
 * @Date 2021/6/30 23:24
 * @Created by gt136
 */
public interface EqualityFactory {
    Equality make(int i, String s, double d);
}
