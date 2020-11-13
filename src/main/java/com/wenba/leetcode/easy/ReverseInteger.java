package com.wenba.leetcode.easy;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/3 5:09 下午
 * @description：    反转整数
 */
public class ReverseInteger {

    public static void main(String[] args) {
        /*int x = 120;
        StringBuilder str = new StringBuilder();
        while (x > 0){
            int m = x % 10;
            x = x / 10;
            str.append(m);
        }
        System.out.println(str.toString());
        System.out.println(Integer.valueOf("-021"));
        System.out.println(Math.negateExact(122222));*/
        System.out.println(reverse1(1234));
        //System.out.println(Math.negateExact(-2147483648));
    }


    // 1234
    public static int reverse1(int x) {
        int res = 0;
        while (x > 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }


        return res;
    }

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        boolean action = false;
        Long res = 0L;
        StringBuilder str = new StringBuilder();
        if (x < 0){
            action =true;
            x = Math.negateExact(x);
        }
        while (x > 0){
            int m = x % 10;
            x = x / 10;
            str.append(m);
        }
        if (str.length() > 0){
            res = Long.valueOf(str.toString());
            if (res > Integer.MAX_VALUE){
                return 0;
            }
            res = action ? Math.negateExact(res) : res;
        }
        return res.intValue();
    }
}
