package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * PreorderTraversal 二叉树的先序遍历
 *
 * @author chappyzhao
 * @version 2024/01/06 15:08
 **/
public class PreorderTraversal {


    public static List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> preorderlist = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !deque.isEmpty()) {

            while (current != null) {
                preorderlist.add(current.val);
                deque.push(current);
                current = current.left;
            }
            TreeNode pop = deque.pop();
            current = pop.right;
        }
        return preorderlist;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1), treeNode1 = new TreeNode(2), treeNode2 = new TreeNode(3);

        treeNode.left = null;
        treeNode.right = treeNode1;

        treeNode1.left = treeNode2;
        treeNode1.right = null;
        List<Integer> integers = preorderTraversal(treeNode);
    }
}
