package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname Individual
 * @Description TODO
 * @Date 2021/4/21 13:57
 * @Created by gt136
 */
public class Individual {

    public Individual(String name) {

    }

    public Individual() {

    }

    public Class<Individual> id(){
        return Individual.class;
    }
    public String toString() {
//        System.out.println(Individual.class);
        return getClass().getSimpleName();
    }
}
