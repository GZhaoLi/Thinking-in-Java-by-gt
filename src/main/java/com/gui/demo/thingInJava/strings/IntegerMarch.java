package com.gui.demo.thingInJava.strings;

/**
 * @Classname IntegerMarch
 * @Description TODO
 * @Date 2021/4/9 17:25
 * @Created by gt136
 */
public class IntegerMarch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
/*输出
true
true
false
true
 */
