package com.leetcode;

public class ReplaceSpace {
    public static String replaceSpace(String s) {
        if (s.length() == 0) {
            return null;
        }

        return s.replace(" ", "%20");
    }
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
