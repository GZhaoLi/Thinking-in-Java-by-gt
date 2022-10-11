package com.gui.demo.thingInJava.strings;

/**
 * @author chappyzhao
 */
public class Solution {

    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] targetNew = sort(target),
                arrNew = sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arrNew[i] != targetNew[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1,2,3,4},
                arr = new int[]{2,4,1,3};
        canBeEqual(target, arr);
    }

}
