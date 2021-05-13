package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname ClassCasts
 * @Description TODO
 * @Date 2021/4/21 11:27
 * @Created by gt136
 */
class Building{}
class House extends Building{}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseClass = House.class;
        House cast = houseClass.cast(b);
        cast = (House) b;
    }
}