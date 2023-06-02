package com.gui.demo.algorithm.find;

import com.gui.demo.algorithm.sort.ProduceArr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chappyzhao
 * @Description
 * @create 2023-03-28 17:08
 */
public class ProduceTree {
    public static List<TreeNode> produceTree(int length) {
        List<TreeNode> tree = new ArrayList<>();

        int[] arr = ProduceArr.getArr(length);
        for (int i = 0; i < length; i++) {
            tree.add(new TreeNode(arr[i]));
        }
        return tree;
    }
}
