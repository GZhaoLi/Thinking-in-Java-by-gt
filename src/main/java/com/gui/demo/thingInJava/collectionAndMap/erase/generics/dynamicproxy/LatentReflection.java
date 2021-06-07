package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname LatentReflection
 * @Description TODO
 * @Date 2021/6/7 14:32
 * @Created by gt136
 */
//没有实现 行为方式
class Mime{
    public void walkAgainstTheWind(){}
    public void sit(){
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls(){}

    @Override
    public String toString() {
        return "Mime";
    }
}
//没有实现 行为
class SmartDog{
    public void speak(){
        System.out.println("Woof!");
    }
    public void sit(){
        System.out.println("Sitting");
    }
    public void reproduce(){}
}
//这个实现了行为Performs
class CommunicateReflectively{
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + "can not speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + "cannot sit");
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            throw new RuntimeException(speaker.toString(), exception);
        }
    }
}
public class LatentReflection {
    public static void main(String[] args) throws AWTException {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}
/*
Woof!
Sitting
Mimecan not speak
Pretending to sit
 */