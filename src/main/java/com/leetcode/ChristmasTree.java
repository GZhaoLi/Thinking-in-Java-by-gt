package com.leetcode;

public class ChristmasTree {
    public static void main(String[] args) {
        int height = 5;
        printChristmasTree(height);
    }

    public static void printChristmasTree(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

