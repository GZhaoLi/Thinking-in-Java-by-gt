package com.gui.demo.thingInJava.annotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：可以用来追踪项目中的用例
 * @Date 2021/11/22 15:48
 * @Created by gt136
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    //如果注解某个方法时没有给出description的值，则该注解的处理器会使用此元素的默认值
    String description() default "no description";
}
