package com.wenba.leetcode.easy;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/2 6:51 下午
 * @description：
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = {2,1};
        int[] nums2 = {11,2,3,4,9}; //[4,9];
        int[] intersection = intersection(nums1, nums2);
        if (intersection != null  && intersection.length > 0) {
            for (int i = 0; i < intersection.length; i++) {
                System.out.println(intersection[i] + "  ");
            }
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0))
            return new int[0];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        Iterator<Integer> iterator = set1.iterator();
        int i = -1;
        while (iterator.hasNext()){
            i++;
            result[i] = iterator.next();
        }
       return result;
    }
}
