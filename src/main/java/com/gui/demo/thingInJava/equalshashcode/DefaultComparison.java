package com.gui.demo.thingInJava.equalshashcode;

/**
 * @Classname DefaultComparison
 * @Description 父类equals
 * @Date 2021/6/30 16:39
 * @Created by gt136
 */
public class DefaultComparison {
    private int i, j, k;

    DefaultComparison(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public static void main(String[] args) {
        DefaultComparison
                a = new DefaultComparison(1, 2, 3),
                b = new DefaultComparison(1, 2, 3);
        System.out.println(a == a);
        System.out.println(a == b);
    }
}
/*
output:
true
false
*/