package com.gui.demo.thingInJava.RTTI;

import java.util.*;

/**
 * @Classname PetCreator
 * @Description TODO
 * @Date 2021/4/21 14:19
 * @Created by gt136
 */
public abstract class PetCreator {
    private Random random = new Random(47);
    /*
    创建不同类型的宠物：抽象的types方法在导出类中实现，以获取由Class对象构成的list（这是模板方法设计模式的一种变体）
    注意：其中类的类型被指定为“任何从Pet导出的类”。因此newInstance()不需要转型就可以产生Pet。
    当导出PetCreator的子类时，唯一所提供的就是创建宠物类型的List
     */
    public abstract List<Class<? extends Pet>> types();
    //随机获取宠物类型
    public Pet randomPet(){
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    //创建宠物数组
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    //将数组封装到集合中
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
