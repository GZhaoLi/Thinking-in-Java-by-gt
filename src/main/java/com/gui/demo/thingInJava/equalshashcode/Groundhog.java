package com.gui.demo.thingInJava.equalshashcode;

/**
 * @Classname Groundhog
 * @Description 看似可以，但是不能作为HashMap的key
 * @Date 2021/7/6 18:06
 * @Created by gt136
 */
public class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
