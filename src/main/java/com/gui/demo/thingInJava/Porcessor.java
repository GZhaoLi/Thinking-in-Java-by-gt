package com.gui.demo.thingInJava;

import java.util.Arrays;
import java.util.Locale;


/**
 * @Classname Porcessor
 * @Description 創建一个能够根据所传递的参数对象的不同而具有不同的行为的方法：被称为策略设计模式
 * @Date 2021/3/17 18:35
 * @Created by gt136
 */
public class Porcessor {
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}
class Upcase extends Porcessor{
    String process(Object input){
        return ((String) input).toUpperCase();
    }
}
class Downcase extends Porcessor{
    String process(Object input){
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Porcessor {
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

class Apply {
    public static void process(ProcessorI p, Object s) {
        System.out.print("using processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "====i love u====";

    public static void main(String[] args) {
    }
}