package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;

import com.gui.demo.thingInJava.collectionAndMap.erase.FilledList1;
import com.gui.demo.thingInJava.lunzi.Suppliers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ApplyTest
 * @Description apply测试
 * @Date 2021/6/8 16:26
 * @Created by gt136
 */
public class ApplyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = Suppliers.create(ArrayList::new, Shape::new, 3);
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 7);

        List<Square> squares = Suppliers.create(ArrayList::new, Square::new, 3);
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 7);

        Apply.apply(new FilledList1<>(Shape::new, 3), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList1<>(Square::new, 3), Square.class.getMethod("rotate"));
    }
}
/*
output:
Shape 0 rotate
Shape 1 rotate
Shape 2 rotate
Shape 0 resize 7
Shape 1 resize 7
Shape 2 resize 7
Square 3 rotate
Square 4 rotate
Square 5 rotate
Square 3 resize 7
Square 4 resize 7
Square 5 resize 7
Shape 6 rotate
Shape 7 rotate
Shape 8 rotate
Square 9 rotate
Square 10 rotate
Square 11 rotate
 */