package com.leetcode.stack;

import java.util.*;

/**
 * 初步想法是使用双层遍历 On2
 * 如果用栈和队列实现的话：
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        //
        if (nums1.length == 0) {
            return null;
        }
        int[] ans = new int[nums1.length];

        int min = -1;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    min = nums1[i];
                    if (j == nums2.length - 1) {
                        ans[i] = -1;
                    }
                    continue;
                }

                if (min != -1 && nums2[j] > min) {
                    ans[i] = nums2[j];
                    break;
                }
                if (j == nums2.length - 1) {
                    ans[i] = -1;
                }
            }
            min = -1;
        }

        return ans;
    }


    /**
     * <p>单调栈用途不太广泛，只处理一种典型的问题，叫 Next Greater Element。</p>
     * <p>NGN 的原始问题：给你一个数组：返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1.
     * 如：给出数组[2,1,2,4,3]，需返回[4,2,4,-1,-1]。这道题的暴力解法很好想到（我就是🥲），但暴力解法的复杂度是O(n∧2).</p>
     * <p>**单调栈解决**：1. 先处理原数组，查询数组中每个元素右边的第一个更大的值倒序遍历原数组；
     * 2. 如何存储第一个子问题的值</p>
     * <p>第一个子问题就是使用单调栈来解决，倒叙遍历原数组，
     * 并用单调栈维护当前位置右边的更大的元素列表，
     * 从栈底到栈顶的元素是单调递减的。</p>
     * <p>具体地，每次我们移动到数组中一个新的位置 i，就将当前单调栈中所有
     * 小于 nums2[i]的元素弹出单调栈，当前位置右边的第一个更大的元素即为栈顶元素，
     * 如果栈为空则说明当前位置右边没有更大的元素。随后我们将位置 i 的元素入栈。</p>
     * @param nums1 num
     * @param nums2 num
     * @return num
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = nextGreaterElement1(new int[]{2, 1, 3}, new int[]{2, 3, 1});
    }
}
