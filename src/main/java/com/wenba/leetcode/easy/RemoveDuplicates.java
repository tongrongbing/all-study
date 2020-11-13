package com.wenba.leetcode.easy;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/10 10:42 上午
 * @description：    删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
       int[] nums = {1,1,2};
       // 0,1,1,1,1,2
        // 0,1,2,3,4
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]){
                continue;
            }
            nums[j+1] = nums[i];
            j++;
        }
        return j+1;
    }
}
