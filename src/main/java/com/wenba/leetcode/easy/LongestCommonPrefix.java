package com.wenba.leetcode.easy;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/28 10:16 上午
 * @description：
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str = {"flxwx","f","flight"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int firstEleLength = strs[0].length();
        for (int i = 0; i < firstEleLength; i++) {
            char ch  = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length()){
                    return strs[0].substring(0,i);
                }
                if (ch != strs[j].charAt(i)){
                     return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
