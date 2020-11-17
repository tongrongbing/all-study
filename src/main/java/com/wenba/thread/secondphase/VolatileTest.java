package com.wenba.thread.secondphase;

import lombok.SneakyThrows;

/**
 * @author：tongrongbing
 * @date：created in 2020/11/16 5:31 下午
 * @description：
 */
public class VolatileTest {

    private  static boolean flag = false;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    if (flag){
                        System.out.println("flag");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("111");
                    flag = true;
                }catch (Exception e){}
            }
        }).start();




    }
}
