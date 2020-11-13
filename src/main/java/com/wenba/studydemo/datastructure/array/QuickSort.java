package com.wenba.studydemo.datastructure.array;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/10 4:22 下午
 * @description： 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {6,1,2,9};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    public static void quickSort(int[] nums,int left,int right){
        if (left < right){
            int base = nums[left];
            int i = left,j = right;
            while (i != j){
                while (i < j && nums[j] > base){
                    j--;
                }
                while (i < j && nums[i] <= base){
                    i++;
                }
                if (i < j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            int temp = nums[i];
            nums[i] = base;
            nums[left] = temp;
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }

    }




}
