package com.gui.demo.thingInJava.innerclasses;

/**
 * @Classname Parcel7
 * @Description TODO
 * @Date 2021/4/2 17:12
 * @Created by gt136
 */
public class Parcel7 {
    public static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination {
        static int x = 20;

        static class AnotherLevel {
            public static void f(){}
            static int x = 20;
        }
    }

    public static ParcelDestination destination() {
        return new ParcelDestination();
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        ParcelDestination d = destination();
    }
}
