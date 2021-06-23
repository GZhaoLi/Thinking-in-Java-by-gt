package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;

import com.gui.demo.thingInJava.collectionAndMap.erase.FilledList1;

import java.util.stream.Stream;

/**
 * @Classname ApplyFunctional
 * @Description TODO
 * @Date 2021/6/8 17:41
 * @Created by gt136
 */
public class ApplyFunctional {
    public static void main(String[] args) {
        Stream.of(
                Stream.generate(Shape::new).limit(2),
                Stream.generate(Square::new).limit(2))
                //把它们压平到一个流中
                .flatMap(c -> c)
                .peek(Shape::rotate)
                .forEach(s -> s.resize(7));
        new FilledList1<>(Shape::new, 2)
                .forEach(Shape::rotate);
        new FilledList1<>(Square::new, 2)
                .forEach(Shape::rotate);
    }
}
/*
output:
Shape 0 rotate
Shape 0 resize 7
Shape 1 rotate
Shape 1 resize 7
Square 2 rotate
Square 2 resize 7
Square 3 rotate
Square 3 resize 7
Shape 4 rotate
Shape 5 rotate
Square 6 rotate
Square 7 rotate
 */