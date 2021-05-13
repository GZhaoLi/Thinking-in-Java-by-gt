package com.gui.demo.thingInJava.innerclasses;

/**
 * @Classname DotNew
 * @Description TODO
 * @Date 2021/3/23 21:30
 * @Created by gt136
 */
public class DotNew {
    public class Inner{}
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
class Parcel4{
    public class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;
        Destination (String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Parcel4.Contents contents = p.new Contents();
        Parcel4.Destination d = p.new Destination("Tasmania");
    }
}