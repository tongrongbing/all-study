package com.wenba.studydemo.javavcore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/13 3:17 下午
 * @description：
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a==b);
        Integer c = 129;
        Integer d = 129;
        System.out.println(c==d);
        Integer e = 127;
        Integer f = 127;
        System.out.println(e==f);

        System.out.println("===================");



        Long h = 128L;
        Long g = 128L;
        System.out.println(h==g);
        Long k = 127L;
        Long m = 127L;
        System.out.println(k==m);

        Map<Long,String>  map  = new HashMap<>();
        map.put(200L,"sss");
        Long vv = 200L;
        System.out.println(map.get(vv));
    }
}
