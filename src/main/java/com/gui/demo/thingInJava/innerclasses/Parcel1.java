package com.gui.demo.thingInJava.innerclasses;

import javax.swing.text.AbstractDocument;

/**
 * @Classname Parcel1
 * @Description TODO
 * @Date 2021/3/23 14:48
 * @Created by gt136
 */
public class Parcel1 {
    static class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
}
