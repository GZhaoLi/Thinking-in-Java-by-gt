package com.gui.demo.thingInJava.streamsProgram;

import com.gui.demo.thingInJava.interface1.Operations;

import java.util.Arrays;

/**
 * @Classname Machine
 * @Description Arrays数组中的方法创建流
 * @Date 2021/6/14 22:13
 * @Created by gt136
 */
public class Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new Operations[]{
                () -> Operations.show("Bing"),
                () -> Operations.show("Crack"),
                () -> Operations.show("Twist"),
                () -> Operations.show("Pop")
        }).forEach(Operations::execute);
    }
}
/*
output:
Bing
Crack
Twist
Pop
 */
