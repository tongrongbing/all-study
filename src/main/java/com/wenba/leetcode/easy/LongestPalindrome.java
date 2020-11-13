package com.wenba.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/29 7:24 下午
 * @description：
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        //System.out.println(longestPalindrome("abccccdd"));
        String s = "abaccccdd";
        int[] count = new int[128];
        count['a'] = 1;
        System.out.println(count['a']);
        char m = 97;
        System.out.println(m);

    }
    // abccccddead
    public static int longestPalindrome(String s){
        if (s == null || s.length() == 0)
            return 0;

        int result = 0;
        boolean action = false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                map.put(c,map.get(c)+1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries){
            Integer value = entry.getValue();
            if (value % 2 == 0){
                result = result + value;
            }else {
                result = result + (value / 2) * 2;
                action  = true;
            }
        }
        return action  ? result + 1 : result;
    }
}
