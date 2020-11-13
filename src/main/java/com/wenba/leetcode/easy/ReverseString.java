package com.wenba.leetcode.easy;


import java.util.Arrays;
import java.util.Stack;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/3 4:19 下午
 * @description：       反转字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        reverseString2(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

    public static void reverseString2(char[] s) {
        for (int i = 0,j = s.length -1; i < j; i++,j--) {
             char temp;
             temp = s[i];
             s[i] = s[j];
             s[j] = temp;
        }

    }

    public static void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        for (int i = 0; i < s.length; i++) {
            if (!stack.empty()){
                s[i] = stack.pop();
            }
        }
    }
}
