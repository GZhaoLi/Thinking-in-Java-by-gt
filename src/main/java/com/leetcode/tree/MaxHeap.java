package com.leetcode.tree;

/**
 * MaxHeap 大顶堆
 *
 * @author chappyzhao
 * @version 2024/01/08 17:11
 **/
public class MaxHeap {

    /**
     * 找出第k个最大值
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums);
        //这里的for不明白
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            heapify(nums, heapSize, 0);
        }
        return nums[0];
    }

    /**
     * 构建大顶堆
     * @param nums array
     */
    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // 初始化最大值的索引
        int leftChild = 2 * i + 1; // 左子节点的索引
        int rightChild = 2 * i + 2; // 右子节点的索引

        // 比较左子节点与根节点
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // 比较右子节点与当前最大值
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // 如果最大值的索引不是当前节点，交换并递归调整
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
