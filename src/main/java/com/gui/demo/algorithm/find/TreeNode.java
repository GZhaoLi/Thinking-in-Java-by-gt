package com.gui.demo.algorithm.find;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chappyzhao
 * @Description
 * @create 2023-03-28 17:06
 */
@Getter
@Setter
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
