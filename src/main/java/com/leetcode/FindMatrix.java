package com.leetcode;

public class FindMatrix {

    public static boolean findNumberIn2DArray(int[][] matrixNum, int target) {
        if (matrixNum.length == 0 || matrixNum[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrixNum.length; ) {
            for (int j = 0; j < matrixNum[0].length; ) {
                if (matrixNum[i][j] < target) {
                    j++;
                    if (matrixNum[0].length == j) {
                        i++;
                        break;
                    }
                } else if (matrixNum[i][j] > target) {
                    i++;
                    break;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] matrixNum = new int[][]{{-1,3}
                };
        System.out.println(findNumberIn2DArray(matrixNum, 3));
    }
}
