package com.leetcode.tree;

/**
 * TreeNode 树节点
 *
 * @author chappyzhao
 * @version 2024/01/04 10:44
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
