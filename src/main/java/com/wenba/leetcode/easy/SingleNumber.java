package com.wenba.leetcode.easy;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/11 6:19 下午
 * @description：    只出现一次的数字
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(0 ^ 1 ^ 2 ^ 1 ^ 2 ^ 4);
        int[] nums = {1,2,1,2,4,6,4};
        System.out.println(singleNumber(nums));
        swap(112,223);
        int m = 4;
        int n = 8;
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
        System.out.println(n);
        System.out.println(m);
    }

    // 1,2,2,1,4
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void swap(int a, int b){
        a = a ^ b;  // a = 112 ^ 223; -->175
        b = a ^ b;  // 175 ^ 223;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
