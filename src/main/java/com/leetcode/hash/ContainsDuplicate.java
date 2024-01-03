package com.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ContainsDuplicate 是否包含相同值
 *
 * @author chappyzhao
 * @version 2024/01/02 16:52
 **/
public class ContainsDuplicate {

    /**
     * 想到了用hash，但却忘了如果保证元素唯一要用Set，啊，太菜了。
     * 改为 HashSet 就很简单了
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateOptimise(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = containsDuplicate(new int[]{3, 3, 1});
    }
}
