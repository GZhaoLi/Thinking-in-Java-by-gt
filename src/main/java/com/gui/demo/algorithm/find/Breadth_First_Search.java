package com.gui.demo.algorithm.find;

import com.gui.demo.algorithm.sort.ProduceArr;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chappyzhao
 * @Description
 * @create 2023-03-27 17:02
 */
public class Breadth_First_Search {

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] arr = ProduceArr.getArr(20);
        int index = 20;
        List<TreeNode> tree = new ArrayList<>();
        List<TreeNode> treeNodes = ProduceTree.produceTree(30);
        TreeNode root = new TreeNode(treeNodes.get(0).getVal());
        int i = bfs(root);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("bb");
        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(i);

    }

    private static int bfs(TreeNode root) {

        /*while (!root.isEmpty()) {
            //
            TreeNode pop = tree.get(0);
            if (pop.getVal() == index) {
                return index;
            }

        }*/
        return 0;
    }
}
