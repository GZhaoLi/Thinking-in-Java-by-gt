package com.leetcode.array;

public class RevoveZeros {
    public static void moveZeroes(int[] nums) {
        int vol = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0&& vol+i<nums.length) {
                vol++;
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }else {
                i++;
            }
        }

    }

    public static void moveZeroesOptimize(int[] nums) {
        int vol = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[vol] = nums[i];
                vol++;
            }
        }
        for (int i = vol; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,0,1});
    }
}
