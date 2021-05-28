package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.thingInJava.lunzi.Generators;

import java.util.*;

/**
 * @Classname Ocean
 * @Description 大鱼吃小鱼
 * @Date 2021/5/12 14:56
 * @Created by gt136
 */
class BigFish{
    private static long count = 0;
    private final long id = count++;
    private BigFish(){
    }
    public String toString(){
        return "BigFish:"+id;
    }

    public static Generator<BigFish> generator() {
        return BigFish::new;
    }
}
class LitterFish{
    private static long count = 0;
    private final long id = count++;
    private LitterFish(){}
    public String toString(){
        return "LitterFish:"+id;
    }
    public static Generator<LitterFish> generator = LitterFish::new;
}
public class Ocean {
    public static void eat(BigFish bigFish,LitterFish litterFish){
        System.out.println(bigFish + "eat:" + litterFish);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<BigFish> queue = new LinkedList<>();
        Generators.fill(queue, BigFish.generator(),5);

        List<LitterFish> list = new ArrayList<>();
        Generators.fill(list, LitterFish.generator, 5);

        for (BigFish b : queue) {
            eat(b,list.get(rand.nextInt(list.size())));
        }

    }
}
