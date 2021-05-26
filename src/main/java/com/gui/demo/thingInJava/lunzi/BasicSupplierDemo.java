package com.gui.demo.thingInJava.lunzi;

import java.util.stream.Stream;

/**
 * @Classname BasicSupplierDemo
 * @Description TODO
 * @Date 2021/5/26 17:21
 * @Created by gt136
 */
public class BasicSupplierDemo {
    public static void main(String[] args) {
        //BasicSupplier 实现
        Stream.generate(BasicSupplier.create(CountedObject.class))
        .limit(5)
        .forEach(System.out::println);

        //这个是用supplier实现
        Stream.generate(CountedObject::new)
                .limit(5)
                .forEach(System.out::println);

    }
}
/*
output:
CountedObject{id=0}
CountedObject{id=1}
CountedObject{id=2}
CountedObject{id=3}
CountedObject{id=4}
CountedObject{id=5}
CountedObject{id=6}
CountedObject{id=7}
CountedObject{id=8}
CountedObject{id=9}
 */