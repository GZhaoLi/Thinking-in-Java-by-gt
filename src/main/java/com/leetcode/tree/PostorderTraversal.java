package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * PostorderTraversal 二叉树的后续遍历
 *
 * @author chappyzhao
 * @version 2024/01/06 15:09
 **/
public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> postorderlist = new ArrayList<>();
        Stack<Integer> output = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            output.push(current.val);

            // 先左后右，保证先将右子树压入栈
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        if (!output.isEmpty()) {
            postorderlist.add(output.pop());
        }
        return postorderlist;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1), treeNode1 = new TreeNode(2), treeNode2 = new TreeNode(3);

        treeNode.left = null;
        treeNode.right = treeNode1;

        treeNode1.left = treeNode2;
        treeNode1.right = null;

        List<Integer> integers = postorderTraversal(treeNode);
    }
}
