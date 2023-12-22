package com.leetcode.array;
/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *  数组相关的题使用双指针法
 *
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i] && (nums.length > i + number)) {
                number++;
                for (int j = i + 1; j < nums.length; j++) {
                    int l = j - 1;
                    nums[l] = nums[j];
                }
                nums[nums.length - 1] = nums[i];
                i--;

            }
        }
        return nums.length - number;
    }

    public static void main(String[] args) {
        int i = removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);

    }
}
