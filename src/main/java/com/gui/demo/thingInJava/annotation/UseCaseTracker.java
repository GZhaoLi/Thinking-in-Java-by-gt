package com.gui.demo.thingInJava.annotation;

import com.gui.demo.thingInJava.annotation.anno.UseCase;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Classname UseCaseTracker
 * @Description TODO
 * @Date 2021/11/23 18:13
 * @Created by gt136
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println();
            }
        }
    }
}
