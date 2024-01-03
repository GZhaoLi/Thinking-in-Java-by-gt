package com.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * FindTheDifferences 找不同
 *
 * @author chappyzhao
 * @version 2024/01/02 17:11
 **/
public class FindTheDifferences {

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                return c;
            }else {
                Integer val = map.get(c);
                if (val == 1) {
                    map.put(c, ++val);
                } else return c;

            }
        }

        return ' ';
    }

    public static void main(String[] args) {

    }
}
