package com.gui.demo.thingInJava.collectionAndMap;

import java.util.Iterator;
import java.util.Random;

/**
 * @Classname CoffeeGenerator
 * @Description
 * @Date 2021/5/10 10:06
 * @Created by gt136
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    //对于Iterator
    private int size = 0;

    public CoffeeGenerator(int sz) {
        this.size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        /**
         * 在这个内部类中实现了iterator接口而重写了两个方法，当创建这个内部类的时候，就会调用重写的
         * @author gt
         * @date 2021/5/10 16:12
         * @return boolean
         */
        @Override
        public boolean hasNext(){
            return count > 0;
        }
        @Override
        public Coffee next(){
            count--;
            return CoffeeGenerator.this.next();
        }


        //不做实现
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 当对这个类调用foreach遍历时，就会调用默认的Iterator方法，而在这里重写了Iterator，就会执行这个方法。但是执行这个方法创建
     * 对内部类的引用后，执行内部类的每一个方法很疑惑
     * @author gt
     * @date 2021/5/10 14:26
     * @return Coffee
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Generator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
/*
输出：
Cappuccino 0
Cappuccino 1
Mocha 2
Cappuccino 3
Mocha 4
Cappuccino 5
Mocha 6
Cappuccino 7
Latte 8
Mocha 9
 */
