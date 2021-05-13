package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname Pug
 * @Description TODO
 * @Date 2021/4/21 14:16
 * @Created by gt136
 */
public class Pug extends Dog{
    private String name = "pug";
    public Pug(String name) {
        super(name);
    }
    public Pug(){
        super();
    }

    @Override
    public String toString() {
        return "Pug{" +
                "name='" + name + '\'' +
                '}';
    }
}
