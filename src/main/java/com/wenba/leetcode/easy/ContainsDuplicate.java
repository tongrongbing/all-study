package com.wenba.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/11 5:58 下午
 * @description：    217. 存在重复元素
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println( containsDuplicate(nums));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (i != 0 && i == set.size()){
                return true;
            }
        }
        return false;
    }
}
