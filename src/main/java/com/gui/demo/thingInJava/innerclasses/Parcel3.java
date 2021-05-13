package com.gui.demo.thingInJava.innerclasses;/**
 * @Classname Parcel3
 * @Description TODO
 * @Date 2021/3/23 15:54
 * @Created by gt136
 */

/**
 * @Classname Parcel3
 * @Description TODO
 * @Date 2021/3/23 15:54
 * @Created by gt136
 */
public class Parcel3 {
    interface Selector{
        boolean end();
        Object current();
        void next();
    }
    private Object[] items;
    private int next = 0;

    public Parcel3(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class Parcel3Selector implements Selector {

        private int i = 0;
        @Override
        public boolean end() {
            //此处访问到了外部类的成员
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new Parcel3Selector();
    }

}
