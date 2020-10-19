package com.wenba.studydemo.javavcore;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/13 3:48 下午
 * @description：
 */
public class LongTest {
    public static void main(String[] args) {
        Long l = 300L;
        Long m = Long.valueOf(300);

        System.out.println(l == m);
        System.out.println(l.equals(m));

        Double d = 1111.0; //Double.valueOf(1111.0);
        double a = 1111.0;
        System.out.println(d == a);

        Double b = new Double(1111.0);
        System.out.println(b == d);

        Integer x = 100;
        Long y = 100L;
        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
    }
}
