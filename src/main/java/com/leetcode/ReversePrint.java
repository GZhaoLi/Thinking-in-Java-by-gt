package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrint {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> stack = new ArrayList<>();
        while (head.next != null) {
            stack.add(head.val);
            head = head.next;
        }
        stack.add(head.val);
        int[] array = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {

            array[stack.size() - 1 - i] = stack.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
