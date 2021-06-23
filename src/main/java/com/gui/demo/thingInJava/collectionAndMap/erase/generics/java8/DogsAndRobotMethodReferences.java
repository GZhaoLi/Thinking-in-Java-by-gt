package com.gui.demo.thingInJava.collectionAndMap.erase.generics.java8;

import com.gui.demo.thingInJava.RTTI.Dog;

import java.util.function.Consumer;

/**
 * @Classname DogsAndRobotMethodReferences
 * @Description TODO
 * @Date 2021/6/8 21:30
 * @Created by gt136
 */
class PerformingDogA extends Dog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce(){}
}
class RobotA{
    public void speak() {
        System.out.println("Click");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void oilChange(){}
}
class CommunicateA{
    public static <P> void perform(P performer,
                                   Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        CommunicateA.perform(new PerformingDogA(),
                PerformingDogA::speak,PerformingDogA::sit);
        CommunicateA.perform(new RobotA(),
                RobotA::speak, RobotA::sit);
    }
}
/*
output:
Woof!
Sitting
Click
Sitting
 */
