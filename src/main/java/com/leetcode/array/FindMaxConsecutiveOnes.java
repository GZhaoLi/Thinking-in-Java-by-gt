package com.leetcode.array;

public class FindMaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int k,t = 0;
        for (int i = 0; i < nums.length; i++) {
            k = 0;
            if (1 == nums[i]) {
                k++;
                if (k > t) {
                    t = k;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 1) {
                        k++;
                        if (k > t) {
                            t = k;
                        }
                    }else {
                        k = 0;
                        break;
                    }
                }
            }
        }
        return t;
    }

    public static int findMaxConsecutiveOnesOptimize(int[] nums) {
        int k = 0, result = 0;
        for (int num : nums) {
            if (1 == num) {
                k++;
                result = Math.max(k, result);
            }
            if (1 != num) {
                result = Math.max(k, result);
                k = 0;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int maxConsecutiveOnes = findMaxConsecutiveOnesOptimize(new int[]{1,1,0,1,1,1});
    }
}
