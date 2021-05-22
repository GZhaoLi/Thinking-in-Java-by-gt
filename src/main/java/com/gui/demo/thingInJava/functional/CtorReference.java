package com.gui.demo.thingInJava.functional;

/**
 * @Classname CtorReference
 * @Description TODO
 * @Date 2021/5/19 22:44
 * @Created by gt136
 */
class Dog{
    private String name;
    //如果不知道的话就是-1
    private int age = -1;
    Dog(){
        name = "yuan";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int years) {
        this.name = name;
        age = years;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String name);
}

interface Make2Arg {
    Dog make(String name, int age);
}
public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;//[1]
        Make1Arg m1a = Dog::new;  //[2]
        Make2Arg m2a = Dog::new;  //[3]

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
    }
}
