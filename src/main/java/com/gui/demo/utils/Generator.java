package com.gui.demo.utils;

/**
 * @Classname Generator
 * @Description 这个类叫做生成器：专门负责创建对象的类，和RandomList有点相似，使用了工厂方法设计模式。
 * @Date 2021/5/10 9:49
 * @Created by gt136
 */
public interface Generator<T> {
    T next();
}
