package com.leetcode.stack;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.List;

public class IsValidBrackets {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] charArray = s.toCharArray();
        for (int i = charArray.length / 2 - 1; i > 0; i--) {
            if (charArray[i] != charArray[charArray.length - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
    }
}
