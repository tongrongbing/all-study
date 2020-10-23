package com.wenba.studydemo.datastructure.array;

import java.util.Arrays;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/23 10:01 上午
 * @description：
 */
public class ArrayTest {
    public static final int[] array = {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {
        int search = search(5);
        removeElementAt(search);
        System.out.println(Arrays.toString(array));

    }

    public static int search(int value){
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static void removeElementAt(int index){
        /*for (int i = index; i < array.length -1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = 0;*/

        System.arraycopy(array,index+1,array,index,array.length-1-index);
        array[array.length-1] = 0;
    }
}
