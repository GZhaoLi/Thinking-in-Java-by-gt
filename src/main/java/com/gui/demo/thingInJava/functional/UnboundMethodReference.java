package com.gui.demo.thingInJava.functional;

/**
 * @Classname youdu
 * @Description 未绑定的方法引用
 * @Date 2021/5/17 20:36
 * @Created by gt136
 */
class X{
    String f(){
        return "X::f()";
    }
}
interface MakeString{
    String make();
}

interface TransformX{
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
//        MakeString ms = X::f;//[1]
        TransformX tx = X::f;
        X x = new X();
        System.out.println(tx.transform(x));//[1]
        System.out.println(x.f());//同等效果
    }
}
/*
print:
X::f()
X::f()
 */