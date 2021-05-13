package com.gui.demo.thingInJava.RTTI;

import javafx.scene.transform.Rotate;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname Shapes
 * @Description TODO
 * @Date 2021/4/19 15:44
 * @Created by gt136
 */
abstract class Shape{
    void draw(){
        System.out.println(this + ".draw()");
    }
    void rotate(){
        System.out.println(this.toString());
    }
    public abstract String toString();
}
class Circle extends Shape{

    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape{
    @Override
    public String toString() {
        return "Square";
    }
}
class Rhomboid extends Shape{
    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class Shapes {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Rhomboid());
        for (Shape shape : shapeList) {
            shape.draw();
            if (!(shape instanceof Circle)) {
                shape.rotate();
            }
            Class.forName("com.gui.demo.thingInJava.RTTI.Square");
            System.out.println("After Class.forName()"+shape.toString());
        }
        //upcast
        Shape rhomboid = new Rhomboid();
        //downcast
        Rhomboid rhomboid1 = (Rhomboid) rhomboid;
        //downcast
        if (rhomboid instanceof Circle){
            Circle rhomboid2 = (Circle) rhomboid;
        }else {
            System.out.println("类型不一致！");
        }

    }
}
/*输出
Circle.draw()
Square.draw()
 */