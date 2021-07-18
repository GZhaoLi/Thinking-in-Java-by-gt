package com.gui.demo.thingInJava.equalshashcode;

import java.util.Objects;

/**
 * @Classname Individual
 * @Description 实现了hashCode 的个体
 * @Date 2021/7/14 11:28
 * @Created by gt136
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual &&
            Objects.equals(id,((Individual) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,id);
    }

    @Override
    //compareTo 会产生一个排序序列，排序的规则首先按照实际类型排序，然后如果有名字的话，按照name排序，最后按照创建的顺序（id）排序
    public int compareTo(Individual o) {
        //首先根据类名比较
        String first = getClass().getSimpleName();
        String oFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(oFirst);
        if (firstCompare != 0) return firstCompare;
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return o.id < id ? -1:(o.id == id ? 0:1);
    }
}
