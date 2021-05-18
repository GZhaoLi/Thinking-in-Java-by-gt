package com.gui.demo.thingInJava.functional;

/**
 * @Classname MethodReferences
 * @Description TODO
 * @Date 2021/5/17 16:35
 * @Created by gt136
 */
interface Callable{//[1]
    void call(String s);
}
class Describe{
    void show(String msg) {//[2]
        System.out.println(msg);
    }
}
public class MethodReferences {
    static void hello(String name) {//[3]
        System.out.println("Hello, " + name);
    }
    //
    static class Description{
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {//[4]
            System.out.println(about + " " + msg);
        }
    }
    //
    static class Helper{
        static void assist(String msg) {//[5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d :: show;//[6]
        c.call("call()");//[7]

        c = MethodReferences :: hello;//[8]
        c.call("Charlie");

        c = new Description("valuable") :: help;//[9]
//        c = Description ::help;
        c.call("information");

        c = Helper::assist;//[10]
        c.call("Help()");
    }
}
/*
print:
call()
Hello, Charlie
valuable information
Help()
 */