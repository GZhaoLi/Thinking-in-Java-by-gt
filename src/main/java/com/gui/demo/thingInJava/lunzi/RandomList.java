package com.gui.demo.thingInJava.lunzi;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Classname RandomList
 * @Description 随机生成一个对象的工具
 * @Date 2021/5/10 0:14
 * @Created by gt136
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
    }
}
/*
输出：
brown over fox quick quick dog brown The brown lazy brown
 */