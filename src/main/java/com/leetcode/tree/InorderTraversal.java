package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * inorderTraversal 二叉树中序遍历
 *
 * @author chappyzhao
 * @version 2024/01/04 10:58
 **/
public class InorderTraversal {

    //初步的想法是使用栈来实现，以根节点为分界线，进行两次出入栈。
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return Collections.singletonList(root.val);
        }

        List<Integer> inorderlist = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode pop = stack.pop();
            inorderlist.add(pop.val);

            current = pop.right;
        }

        return inorderlist;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1), treeNode1 = new TreeNode(2), treeNode2 = new TreeNode(3);

        treeNode.left = null;
        treeNode.right = treeNode1;

        treeNode1.left = treeNode2;
        treeNode1.right = null;

        List<Integer> integers = inorderTraversal(treeNode);
    }
}
