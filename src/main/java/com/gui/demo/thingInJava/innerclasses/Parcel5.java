package com.gui.demo.thingInJava.innerclasses;


/**
 * @Classname Parcel5
 * @Description TODO
 * @Date 2021/3/25 21:53
 * @Created by gt136
 */
public class Parcel5 {
    public Contents contents(){
        return new Contents(){
            private int i = 11;
            public int value(){
                return i;
            }
        };
    }
    public static void main(String[] args){
        Parcel5 p = new Parcel5();
        Contents c = p.contents();
        System.out.println(c.value());
    }
}
interface Contents{
    int i = 11;
    int value();
}
class Parcel6{
    class MyContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    public Contents contents(){
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        Contents c = p.contents();
        System.out.println(c.value());
        try {

        }finally {
            
        }
    }

}
