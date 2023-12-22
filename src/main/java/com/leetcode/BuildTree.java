package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private static Map<Integer,Integer> inOrderIndexMap;

    private static TreeNode nodeAlone(int[] preorder, int preLeft, int preRight,
                                 int[] inorder, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(9);
        objects.remove(objects.size());
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int pIndex = inOrderIndexMap.get(rootValue);

        root.left = nodeAlone(preorder, preLeft + 1, preLeft + pIndex - inLeft, inorder, inLeft, pIndex - 1);
        root.right = nodeAlone(preorder, preLeft + pIndex - inLeft + 1, preRight, inorder, pIndex + 1, inRight);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

        inOrderIndexMap = new HashMap<>();

        int[] array = new int[preorder.length];
        array[0] = preorder[0];

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return nodeAlone(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{},
                inorder = new int[]{};
        TreeNode treeNode = buildTree(preOrder, inorder);

        System.out.println(treeNode.val);
    }
}
