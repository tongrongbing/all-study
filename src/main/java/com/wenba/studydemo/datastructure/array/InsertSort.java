package com.wenba.studydemo.datastructure.array;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/14 3:59 下午
 * @description：
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {9,7,2,1};
        insertSort(array);

    }

    /**
     * @author: tongrongbing
     * @description:
     *
     *
     *  min = 6
     */
    private static void insertSort(int[] arr){
        for(int i = 1 ; i < arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while (j > 0 && temp < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }

        }


        display(arr);
    }


    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
