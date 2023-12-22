package com.leetcode.list;

import com.gui.demo.thingInJava.collectionAndMap.Mocha;

import java.util.ArrayList;
import java.util.List;

/**
 * 203.给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 像单链表这种重复操作的动作 可以使用递归来实现
 */
public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode nodeBefore = null;

        if (node == null) {
            return null;
        }
        while (node.next != null) {
            if (node.val == val) {
                ListNode nodeNew = node.next;
                if (nodeBefore != null) {
                    nodeBefore.next = nodeNew;
                }else {
                    head = nodeNew;
                }
                node = nodeNew;
                continue;
            }
            nodeBefore = node;
            node = node.next;
        }
        if (node.val == val) {
            if (nodeBefore == null) {
                return null;
            }else {
                nodeBefore.next = null;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        List<ListNode> list = new ArrayList<>();
        list.add(new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,null))))))));


        ListNode listNode = removeElements(list.get(0), 6);
    }
}
