package com.gui.demo.jvm.jvmengine;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author chappyzhao
 */
public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader( String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String classPath) throws IOException {
        classPath = classPath.replaceAll("\\.", "/");
        return Files.readAllBytes(Paths.get(classPath));

    }
    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes;
        try {
            bytes = loadByte(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    @Override
    public URL getResource(String name) {

        return super.getResource(name);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("/Users/chappyzhao/Documents/project/Thinking-in-Java-by-gt/target/classes/com/gui/demo/jvm/jvmengine/MyClassLoader.class");
        Class<?> aClass = classLoader.loadClass("/Users/chappyzhao/Documents/GoodsPriceVo");
        Object o = aClass.newInstance();
        Method getActivityId = aClass.getDeclaredMethod("getActivityId", null);
        getActivityId.invoke(o, null);
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
