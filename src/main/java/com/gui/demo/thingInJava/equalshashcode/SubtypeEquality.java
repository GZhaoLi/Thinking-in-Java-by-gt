package com.gui.demo.thingInJava.equalshashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Classname SubtypeEquality
 * @Description TODO
 * @Date 2021/7/1 23:09
 * @Created by gt136
 */
enum Size {
    /**
     *
     */
    SMALL, MEDIUM, LARGE;

    Size curgentToDouble() {
        return values()[ordinal()];
    }
}


class Animal {
    private static int counter = 0;
    private final int id = counter++;
    private final String name;
    private final Size size;

    Animal(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return //id == animal.id && //[1]
                Objects.equals(name, animal.name) && size == animal.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
//        return Objects.hash(id, name, size);
    }

    @Override
    public String toString() {
        return String.format("%s[%d]: %s %s %x",
                getClass().getSimpleName(), id, name, size, hashCode());
    }
}
class Dog extends Animal {
    Dog(String name, Size size) {
        super(name, size);
    }
}

class Pig extends Animal {
    Pig(String name, Size size) {
        super(name, size);
    }
}
class Dog2 extends Animal{
    Dog2(String name, Size size) {
        super(name, size);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Dog2 && super.equals(o);
    }
}
class Pig2 extends Animal {
    Pig2(String name, Size size) {
        super(name, size);
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Pig2 && super.equals(o);
    }
}
/**
 * @author chappyzhao
 */
public class SubtypeEquality {
    public static void main(String[] args) {
        Set<Animal> pets = new HashSet<>();
        pets.add(new Dog2("Ralph", Size.MEDIUM));
        pets.add(new Pig2("Ralph", Size.MEDIUM));
        pets.forEach(System.out::println);
    }
}
/*
output:
Dog[0]: Ralph MEDIUM d1c09fb
Pig[1]: Ralph MEDIUM d1c09fb
 */