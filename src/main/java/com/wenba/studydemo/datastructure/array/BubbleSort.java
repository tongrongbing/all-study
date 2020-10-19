package com.wenba.studydemo.datastructure.array;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/13 5:22 下午
 * @description：冒泡排序：从无序数组的左边第一个元素开始与 相邻的元素两两比较，
 * 若左边的元素大于右边的元素则交换位置，否则不交换。直到最大的元素从最右边依此排列展示。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2,7,3,1,6,0,4,5,9,8}; //7,3,2--- 3,2,7  2,3,7

        bubbleSort(array);

    }

    private static void bubbleSort(int[] array){
        int temp =0;
         for(int i = 1; i < array.length; i++){
             boolean action = true;
             for(int  j = 0; j < array.length-i;j++){
                if(array[j] > array[j+1]){
                    // 交换位置
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    action = false;
                }
             }
             if(action){
                break;
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
