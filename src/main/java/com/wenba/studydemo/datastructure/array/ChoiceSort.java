package com.wenba.studydemo.datastructure.array;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/13 5:59 下午
 * @description： 选择排序：假设从无序数组左边第一个元素开始，与剩下的元素比较，找到最小元素与该轮次第一次比较的位置交换。
 */
public class ChoiceSort {
    public static void main(String[] args) {
        int[] array = {2,7,3,0,1,4,5,6,8,9};
        choiceSort(array);

    }

    /**
     * @author: tongrongbing
     * @description:
     *
     *  0 1 2 3 4 5 6 7 9 8
     *  min = 6
     */
    private static void choiceSort(int[] array){
         for(int i = 1 ; i < array.length; i++){  // n-1轮比较
             int min = array[i-1];
             int index = -1;
             for(int j = i; j < array.length ; j++){
                 if(array[j] < min){
                     min = array[j];
                     index = j;
                 }
             }
             // 交换位置，注意需要弄清楚 不交换位置的临界条件。
             int temp = 0;
             if(index != -1){
                 temp = array[i-1];
                 array[index] = temp;
                 array[i-1] = min;
             }
             System.out.print("第"+i+"轮排序后的结果为:");
             display(array);
         }
    }

    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
