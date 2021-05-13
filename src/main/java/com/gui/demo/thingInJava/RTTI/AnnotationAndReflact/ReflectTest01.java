package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

import java.sql.SQLOutput;

/**
 * @Classname ReflectTest01
 * @Description TODO
 * @Date 2021/4/27 11:39
 * @Created by gt136
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        //通过反射获取类的Class引用
        Class aClass = null;
        Class aClass2 = null;
        try {
            aClass = Class.forName("com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.User");
            aClass2 = Class.forName("com.gui.demo.thingInJava.RTTI.AnnotationAndReflact.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);
        System.out.println(aClass2);
        //一个类在内存中只能有一个Class对象,元素类型一样的也是只有一个Class对象，且它被加载后，类的整个结构都会被封装在类对象中
        if (aClass != null && aClass2 != null)
        System.out.println(aClass == aClass2);
    }
}

class User{
    private String name;
    private Integer age;
    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public User(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}