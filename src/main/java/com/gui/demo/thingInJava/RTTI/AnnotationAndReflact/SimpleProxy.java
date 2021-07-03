package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

/**
 * @Classname SimpleProxy
 * @Description TODO
 * @Date 2021/4/28 17:57
 * @Created by gt136
 */
interface Interface{
    void doSomeThing();
    void somethingElse(String args);
}
class RealObject implements Interface{

    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing.");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse " + args);
    }
}
class SimpleProxyDemo implements Interface{
    private Interface proxied;

    public SimpleProxyDemo(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomeThing() {
        System.out.println("simpleProxyDemo doSomething");
        proxied.doSomeThing();
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("SimpleProxyDemo somethingElse");
        proxied.somethingElse("args");
    }
}
public class SimpleProxy {
    static void consumer(Interface iface) {
        iface.doSomeThing();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxyDemo(new RealObject()));
    }
}
/*
输出：插入了代理的原因是为了我们可以执行额外的操作
doSomeThing.
somethingElse bonobo
simpleProxyDemo doSomething
doSomeThing.
SimpleProxyDemo somethingElse
somethingElse args
 */