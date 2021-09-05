package com.gui.demo.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Classname JavaMethodAreaOOM
 * @Description -XX:PermSize=10M -XX:MaxPermSize=10M
 *  jdk 8 中无法运行，因为永久代已经被替代了，上边的设置直接警告
 * @Date 2021/8/31 23:33
 * @Created by gt136
 */
public class JavaMethodAreaOOM {
    static class OOMObject {

    }
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects,args));
            enhancer.create();
        }
    }
}
