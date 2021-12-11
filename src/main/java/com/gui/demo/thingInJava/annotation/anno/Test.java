package com.gui.demo.thingInJava.annotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 一个注解类
 * @Date 2021/11/22 11:19
 * @Created by gt136
 */
@Target(ElementType.METHOD)//定义的注解可以应用在哪里（比如方法还是字段）
@Retention(RetentionPolicy.RUNTIME)//定义了注解在哪里可用，在源代码中（SOURCE），class文件（CLASS）或者是运行时（RUNTIME）
public @interface Test {
}
