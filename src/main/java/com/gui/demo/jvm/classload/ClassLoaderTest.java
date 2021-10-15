package com.gui.demo.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname ClassLoaderTest
 * @Description TODO
 * @Date 2021/10/15 10:33
 * @Created by gt136
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myloader.loadClass("com.gui.demo.jvm.classload.ClassLoaderTest")
                .newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.gui.demo.jvm.classload.ClassLoaderTest);
    }
}
/*
output.
class com.gui.demo.jvm.classload.ClassLoaderTest
false
 */