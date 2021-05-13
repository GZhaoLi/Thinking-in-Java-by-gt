package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Classname TestSpeed
 * @Description TODO
 * @Date 2021/4/27 16:58
 * @Created by gt136
 */
public class TestSpeed {
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getAge();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法：" + (endTime - startTime)+"ms");
    }

    public static void test02(){
//        Class<User> userClass = User.class;
        User user = new User();
        Class aClass = user.getClass();
        long startTime = 0;
        long endTime = 0;
        try {
            Method getAge = aClass.getDeclaredMethod("getAge", null);
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000000; i++) {
                getAge.invoke(user, null);
            }
            endTime = System.currentTimeMillis();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("反射：" + (endTime - startTime)+"ms");
    }
    public static void main(String[] args) {
        /*test01();
        test02();*/
        ShowMethods.main(new String[]{"com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.ShowMethods"});
    }
}
