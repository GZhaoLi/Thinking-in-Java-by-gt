package com.gui.demo.thingInJava.collectionAndMap.erase;

import com.gui.demo.thingInJava.lunzi.New;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname BasicBounds
 * @Description TODO
 * @Date 2021/5/30 16:18
 * @Created by gt136
 */
interface HasColor{
    Color getColor();
}

interface HasYellow {

}
//此处是继承了一个接口，这是泛型限定边界的不同之处。在边界这里的extends和我们所理解的extends的含义完全不同
class WithColor<T extends HasColor> {
    T item;
    WithColor(T item){
        this.item = item;
    }

    T getItem() {
        return item;
    }
    //绑定之后，则可以调用继承类中的方法
    Color color() {
        return item.getColor();
    }
}

class Coord {
    public int x, y, z;
}
//这里注意绑定必须先继承类再继承接口
//多重绑定
class WithColorCoord<T extends Coord & HasColor> {
    T item;

    WithColorCoord(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
    Color color() {
        return item.getColor();
    }
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}


class Solid<T extends Coord & Weight & HasColor> {
    T item;

    Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
    int weight() {
        return item.weight();
    }
}
class NextSom implements HasColor {
    @Override
    public Color getColor() {
        return null;
    }
}
class Bounded extends Coord implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds {
    static <ll extends HasYellow & HasColor> void use() {

    }
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getItem();
        solid.getX();
        solid.getY();
        solid.weight();
        List<? extends HasColor> list = new ArrayList<>();
//        list.add(new Bounded());
        List<Bounded> boundeds = Arrays.asList(new Bounded());
        List<? extends HasColor> list1 = boundeds;

        //        List<HasColor> list = new ArrayList<Bounded>();
        List<? extends HasColor> list2 = new ArrayList<Bounded>();
//        list2.add(new Bounded());
//        list2.add(new NextSom());
//        list.add(new Object());

    }
}
