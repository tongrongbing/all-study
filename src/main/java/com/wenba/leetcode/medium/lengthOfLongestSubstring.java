package com.wenba.leetcode.medium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/28 9:42 上午
 * @description： 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 。
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    /**
     * @author: tongrongbing
     * @description:
     *  基于Map方法 map的key是字符 ，value是 对应的索引。
     *  利用滑动窗口思想，当左指针向右移动一格，则右指针一直向右边移动，直到满足条件，也即是查找到重复的字符。
     *  这时候，利用map的get方法 获取到重复字符 如 c 的之前的索引位置：2，该索引位置就作为新的左指针位置，而不用从索引1 和 2 位置
     *  在移动，目的是减少移动的次数。然后左指针向右移动，右指针一直向右边移动，直到满足条件，如此循环，直到右指针指向最后一个字符的位置。
     *
     * @time: 2020/10/29 2:48 下午
     * @param s
     * @return int
     */
    public static int lengthOfLongestSubstring3(String s){
        int max = 0;
        if (s == null || s.length() == 0)
            return max;
        int length = s.length();
        Map<Character,Integer> map =  new HashMap<>();
        for (int left = 0,right = 0; right < length ; right++){
          char ch = s.charAt(right);
          if (map.containsKey(ch)) {
              left = Math.max(left,map.get(ch)+1);
          }
           max = Math.max(max,right - left  + 1);
           map.put(ch,right);
        }
        return max;
    }

    //  pwwkew
    public static int lengthOfLongestSubstring2(String s) {
      return 0;
    }



    public static int lengthOfLongestSubstring(String s) {
      // 哈希集合，记录每个字符是否出现过  abcacbdddx
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


}
