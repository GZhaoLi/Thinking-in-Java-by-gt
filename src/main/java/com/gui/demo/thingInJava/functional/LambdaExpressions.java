package com.gui.demo.thingInJava.functional;

import sun.reflect.misc.MethodUtil;

/**
 * @Classname LambdaExpressions
 * @Description TODO
 * @Date 2021/5/17 14:55
 * @Created by gt136
 */
interface Description{
    String brief();
}
interface Body{
    String detailed(String head);
}
interface Multi{
    String twoArg(String head, Double d);
}

public class LambdaExpressions {
    static Body body = h -> h + "No Parents!";//[1]
    static Body body2 = (head -> head + "More details");//[2]
    static Description desc = () -> "Short info";//[3]
    static Multi multi = (h, n) -> h + n;//[4]
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(body.detailed("Oh!"));
        System.out.println(body2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Pi!", 3.14159));
        System.out.println(moreLines.brief());
    }
}
/*
print:
Oh!No Parents!
Hi!More details
Short info
Pi!3.14159
moreLines()
from moreLines()
 */