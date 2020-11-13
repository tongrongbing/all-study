package com.wenba.leetcode.easy;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/10 11:41 上午
 * @description： 旋转数组
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};   // 4,5,6,7,1,2,3     4,5,6,7,3,2,1
       /* rotate(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println(); // 1,2,3,4*/
        int k = 3;
        k =  k % nums.length;
        rotate2(nums,0,nums.length-1); // 第一次
        rotate2(nums,0,k-1); // 第二次
        rotate2(nums,k,nums.length-1); // 第三次

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }


    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        k = k % nums.length;
        for (int i = 0; i < k ; i++) {
            int temp = nums[nums.length-1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public static void rotate2(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
