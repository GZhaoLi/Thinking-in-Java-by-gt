package com.gui.demo.thingInJava.RTTI;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ForNameCreator
 * @Description TODO
 * @Date 2021/4/21 14:53
 * @Created by gt136
 */
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    //你想随机创建的类型
    private static String[] typeNames = {
            "com.gui.demo.thingInJava.RTTI.Mutt",
            "com.gui.demo.thingInJava.RTTI.Pug",
            "com.gui.demo.thingInJava.RTTI.Cat",
            "com.gui.demo.thingInJava.RTTI.EgyptianMau",
            "com.gui.demo.thingInJava.RTTI.Cymric"
    };
    /*
     * loader()用Class.forName()创建了Class对象的List，为了产生具有实际类型的Class对象的List，必须使用转型。
     * loader()被单独定义，然后被置于一个静态初始化子句中，因为@SuppressWarnings注解不能直接置于静态初始化子句上
     * @author gt
     * @date 2021/4/22 9:52 
     */
    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String name : typeNames) {
                //将宠物类型添加到types中，供选择
                types.add(
                        (Class < ? extends Pet >) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    static {
        loader();
    }
}
