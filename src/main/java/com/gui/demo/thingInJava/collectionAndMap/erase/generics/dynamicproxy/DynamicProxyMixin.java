package com.gui.demo.thingInJava.collectionAndMap.erase.generics.dynamicproxy;

import com.gui.demo.thingInJava.collectionAndMap.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static com.gui.demo.thingInJava.lunzi.GeneratorTuple.tuple;

/**
 * @Classname DynamicProxyMixin
 * @Description 动态代理
 * @Date 2021/6/6 16:41
 * @Created by gt136
 */
class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    @SuppressWarnings("unchecked")
    MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair :
                pairs) {
            for (Method me : pair.second.getMethods()) {
                System.out.println(pair.first);
                System.out.println(pair.second);
                System.out.println(pair.first.getClass().getMethods());
                System.out.println(pair.second.getMethods());
                String methodName = me.getName();
                //
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    //这个是一个实现，根据传入的对象数组，取出其中的接口字段再重新组合到接口数组中，作为InvocationHandler的第二个参数
    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        //接口数组
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            //将数组中的第i个元素的第二个接口类获取到
            interfaces[i]  = (Class) pairs[i].second;
        }
        //类加载器是tuple中的实现类来获取类加载器
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    private static class BasicImpl implements Basic {
        private String val;

        @Override
        public void set(String val) {
            this.val = val;
        }

        @Override
        public String get() {
            return val;
        }
    }

    public static void main(String[] args) {
        //先将这三对接口和实现类传入代理类
        Object mixin = MixinProxy.newInstance(tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
/*
output:
Hello
1623035786112
1
 */