package com.gui.demo.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author chappyzhao
 * @Description
 * @create 2023-03-21 16:46
 */
public class ProduceArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getArr(10)));
    }
    public static int[] getArr(int length) {
        Random rand = new Random(40);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(10000);

        }
        return arr;
    }
}
