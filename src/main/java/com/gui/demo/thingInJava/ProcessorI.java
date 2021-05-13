package com.gui.demo.thingInJava;/**
 * @Classname ProcessorI
 * @Description TODO
 * @Date 2021/3/17 21:27
 * @Created by gt136
 */

/**
 * @Classname ProcessorI
 * @Description 改写
 * @Date 2021/3/17 21:27
 * @Created by gt136
 */
public interface ProcessorI {
    String name();

    Object process(Object input);
}
class Apply2{
    public static void process(Porcessor p, Object s) {
        System.out.print("using processor " + p.name());
        System.out.println(p.process(s));
    }
}


