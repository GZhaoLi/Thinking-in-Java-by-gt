package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname MyAnnotation
 * @Description TODO
 * @Date 2021/4/27 9:55
 * @Created by gt136
 */
public class MyAnnotation {
    //注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotationTest(value="gui")
    public void test(){

    }
}

/**
 * 定义一个自定义注解
 */
//注释作用域
@Target({ElementType.TYPE,ElementType.METHOD})
//定义了注释保留时间的长短
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationTest{
    //不是方法，只是注解的参数：参数类型+参数名();
    String value();
    int age() default 18;
}
