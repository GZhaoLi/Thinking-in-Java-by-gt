package com.gui.demo.thingInJava.streamsProgram;
import static com.gui.demo.thingInJava.streamsProgram.optional.RandInts.*;
/**
 * @Classname SelectElement
 * @Description 流查找
 * @Date 2021/6/23 9:24
 * @Created by gt136
 */
public class SelectElement {
    public static void main(String[] args) {
        //rands方法将数组转化为流，findFirst
        System.out.println(rands().findFirst().getAsInt());
        System.out.println(rands().parallel().findFirst().getAsInt());
        System.out.println(rands().findAny().getAsInt());
        System.out.println(rands().parallel().findAny().getAsInt());
    }
}
/*
output:
258
258
258
242
 */