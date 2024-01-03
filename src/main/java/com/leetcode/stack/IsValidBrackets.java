package com.leetcode.stack;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Stack;

/**
 * 20
 */
public class IsValidBrackets {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            Character peek = null;
            if (!stack.empty()) {
                peek = stack.peek();
            }
            stack.push(c);
            if (peek != null && (stack.peek().equals(')') && peek.equals('(') ||
                    stack.peek().equals(']') && peek.equals('[') ||
                    stack.peek().equals('}') && peek.equals('{'))) {
                stack.pop();
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
    }
}
