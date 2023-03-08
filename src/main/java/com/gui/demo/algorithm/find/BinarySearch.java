package com.gui.demo.algorithm.find;

import static java.util.Arrays.binarySearch;

/**
 * @author chappyzhao
 * @Description
 * @create 2023-03-08 10:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] bucket = new int[]{1, 3, 5, 6, 7, 8, 11, 35, 77, 88};
        int findNum = 88;
        int i = binarySearch(bucket, 0, bucket.length - 1, findNum);
        System.out.printf("find:" + i);
    }

    public static int binarySearch(int[] arr, int fromIndex, int toIndex, int findNum) {
        int low = fromIndex;
        int high = toIndex;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] > findNum) {
                high = mid - 1;
            }else if (arr[mid] < findNum) {
                low = mid + 1;
            }else{ return mid;}

        }
        return 0;
    }
}
