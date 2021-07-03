package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

import com.fasterxml.jackson.databind.util.Named;
import javafx.beans.property.ReadOnlyLongProperty;
import org.springframework.data.domain.ExampleMatcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname SimpleDynamicProxy
 * @Description TODO
 * @Date 2021/4/29 10:59
 * @Created by gt136
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    //proxy：所调用方法的代理实例  method：被调用的Method实例与代理实例中的接口方法对应的方法 args：包含在代理实例的方法调用中传递的参数值的对象数组，如果接口方法不带参数，则为null。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** proxy: " + proxy.getClass() + ",method: " + method + ",args: " + args);
        if (args != null)
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomeThing();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
/*
输出：
doSomeThing.
somethingElse bonobo
*** proxy: class com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.$Proxy0,method: public abstract void com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.Interface.doSomeThing(),args: null
doSomeThing.
*** proxy: class com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.$Proxy0,method: public abstract void com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.Interface.somethingElse(java.lang.String),args: [Ljava.lang.Object;@58372a00
 bonobo
somethingElse bonobo
 */
