package com.gui.demo.thingInJava.collectionAndMap;

import java.util.ArrayList;

/**
 * @Classname CollectionData
 * @Description 泛型填充集合
 * @Date 2021/5/7 15:53
 * @Created by gt136
 */
public class CollectionData<T> extends ArrayList<T> {
    /*
     * 是这个类的有参构造器，传入了两个参数
     * @author gt
     * @date 2021/5/7 16:56
     * @param gen 是一个接口，有一个next方法
     * @param quantity 数量
     * @return null
     */
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            //因为此类继承了ArrayList，add是ArrayList中的方法：往此集合中添加元素
            add(gen.next());
        }
    }
    //泛型方法
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
