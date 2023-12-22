package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        int[] arr = new int[length];
        int i = 0;
        node = head;
        while (node.next != null) {
            arr[i++] = node.val;
            node = node.next;
        }
        arr[i] = node.val;
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        for (int j = arr.length - 1; j >= 0; j--) {
            newHead.val = arr[j];
            newHead.next = new ListNode();
            newHead = newHead.next;
        }
        return newTail;
    }


        public ListNode reverseListOptimize(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    public static void main(String[] args) {
        List<ListNode> list = new ArrayList<>();
        list.add(new ListNode(1, new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,null))))))));


        ListNode listNode = reverseList(list.get(0));
    }
}
