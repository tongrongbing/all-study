package com.wenba.studydemo.datastructure.recursion;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/14 6:35 下午
 * @description：
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(fibo(6));
    }

    /**
     * @author: tongrongbing
     * @description:
     *
     * 1,1,2,3,5,8,13,21,34,55....
     *
     */
    private static int fibo(int n){
        if(2 >= n){
            return 1;
        }
       return fibo(n-1) + fibo(n-2);
    }
}
